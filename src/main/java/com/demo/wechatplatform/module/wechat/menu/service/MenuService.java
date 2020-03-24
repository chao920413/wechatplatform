package com.demo.wechatplatform.module.wechat.menu.service;

import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

public interface MenuService {

    void create(WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage, WxMenu wxMenu);

    void delete(WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage);
}
