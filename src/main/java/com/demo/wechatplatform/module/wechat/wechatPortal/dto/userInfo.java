package com.demo.wechatplatform.module.wechat.wechatPortal.dto;

import lombok.Data;

@Data
/**
 * 拉取的用户信息
 */
public class userInfo {
    public String OPENID ;
    public String nickname ;
    public String  sex;
    public String  province;
    public String  city;
    public String  country;
    public String  headimgurl;
    public String[]  privilege;
    public String  unionid;
}
