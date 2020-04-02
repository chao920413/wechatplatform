package com.demo.wechatplatform;

import com.demo.wechatplatform.config.WxMappingJackson2HttpMessageConverter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@SpringBootApplication
public class WechatplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatplatformApplication.class, args);
    }
    @Bean
    public HttpClient httpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", csf)
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(5);
        connectionManager.setDefaultMaxPerRoute(5);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(100000)
                .setConnectTimeout(8000)
                .setConnectionRequestTimeout(100000)
                .build();

        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }

    @Bean
    public ClientHttpRequestFactory httpRequestFactory() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }
    @Bean
    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        RestTemplate restTemplate= new RestTemplate(httpRequestFactory());
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}

