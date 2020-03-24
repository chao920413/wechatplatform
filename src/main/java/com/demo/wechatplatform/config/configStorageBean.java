package com.demo.wechatplatform.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configStorageBean {

    @Autowired app app;
    @Bean
    public WxMpInMemoryConfigStorage initWxMpInMemoryConfigStorage(){
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage=new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(app.getAppid());
        wxMpInMemoryConfigStorage.setSecret(app.getSecret());
        wxMpInMemoryConfigStorage.setToken(app.getToken());
        return wxMpInMemoryConfigStorage;
    }

    @Bean
    public WxMpServiceImpl initWxMpServiceImpl(){
        WxMpServiceImpl wxMpService=new WxMpServiceImpl();
     //   wxMpService.
        return wxMpService;
    }
}
