package com.demo.wechatplatform.module.wechat.wechatPortal.controller;

import com.demo.wechatplatform.config.RestTemplateUtil;
import com.demo.wechatplatform.module.wechat.wechatPortal.dto.access_token;
import com.demo.wechatplatform.module.wechat.wechatPortal.dto.userInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/signUp")
public class signUpController {

    @Autowired
    private RestTemplate restTemplate ;
  /*  @RequestMapping(value = "/signUp",method = RequestMethod.GET)
    public String signUp(@RequestParam(value = "signature") String signature,
                         @RequestParam(value = "timestamp") String timestamp,
                         @RequestParam(value = "nonce") String nonce,
                         @RequestParam(value = "echostr") String echostr	){


        return echostr;
    }*/
    @PostMapping( produces = "application/xml; charset=UTF-8")
    public String post(
                       @RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
        String out = null;
        WxMpXmlOutMessage outMessage = new WxMpXmlOutTextMessage();
        outMessage = WxMpXmlOutMessage.TEXT().content("这是一个click请求")
                .fromUser(inMessage.getToUserName()).toUser(inMessage.getFromUserName())
                .build();
        if (outMessage == null) {
            return "";
        }
        out = outMessage.toXml();
        return out;
    }

    @RequestMapping(value = "getWebToken_AcessByCode")
    public Map<String,String> getUserInfo(@RequestBody access_token access_token){
        RestTemplate restTemplate= RestTemplateUtil.getInstance();
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        url=String.format(url,"wx73da6c3a780f0ea2","92809e6b89e09737d59f9a69663c0a34",access_token.getCode());
        Gson gson=new Gson();
        access_token=  restTemplate.getForObject(url,access_token.getClass());


        userInfo usrInfo=new userInfo();
        String url_user="https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
        url_user=String.format(url_user,access_token.getAccess_token(),access_token.getOpenid());
        usrInfo=restTemplate.getForObject(url_user,usrInfo.getClass());
        Map<String,String > map =new HashMap<>();
        map.put("code", "200");
        map.put("name",usrInfo.getNickname());
        map.put("picture",usrInfo.getHeadimgurl());
        return map;
    }

}
