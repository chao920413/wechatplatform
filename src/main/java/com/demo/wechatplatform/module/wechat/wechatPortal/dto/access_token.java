package com.demo.wechatplatform.module.wechat.wechatPortal.dto;

import lombok.Data;

@Data
public class access_token {
    /**
     * 前端获取的code
     */
    public String code;

    /**
     * 根据code获取到的信息
     */
    public String access_token;
    public String expires_in;
    public String refresh_token;
    public String openid;
    public String scope;
}
