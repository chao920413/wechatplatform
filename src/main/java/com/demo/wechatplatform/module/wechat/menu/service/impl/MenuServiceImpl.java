package com.demo.wechatplatform.module.wechat.menu.service.impl;

import com.demo.wechatplatform.module.wechat.menu.service.MenuService;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class MenuServiceImpl implements MenuService {

    @Override
    public void create(WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage, WxMenu wxMenu) {
        WxMpService service = new WxMpServiceImpl();
        service.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        try {
            service.menuCreate(wxMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage) {
        WxMpService service = new WxMpServiceImpl();
        service.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        try {
            service.menuDelete();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
}
