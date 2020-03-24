package com.demo.wechatplatform.module.wechat.handler;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

@Component
public class DealMessage {

    public WxMpXmlOutMessage received(WxMpXmlMessage wxMpXmlMessage){
        //对消息进行拆分处理
        String msgType=wxMpXmlMessage.getMsgType();
/*        switch (msgType){
            case "text":

        }*/
    return null;
    }

}
