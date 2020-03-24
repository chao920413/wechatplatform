package com.demo.wechatplatform.module.wechat.wechatPortal.controller;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import org.springframework.web.bind.annotation.*;

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

}
