package com.demo.wechatplatform.module.wechat.wechatPortal.controller;

import com.demo.wechatplatform.module.wechat.wechatPortal.dto.access_token;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/signUp")
public class signUpController {

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
    public String getUserInfo(@RequestBody access_token access_token){
        RestTemplate restTemplate=new RestTemplate();
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        url=String.format(url,"wx73da6c3a780f0ea2","92809e6b89e09737d59f9a69663c0a34",access_token.getCode());
        access_token=restTemplate.getForObject(url,access_token.getClass());
        return null;
    }

}
