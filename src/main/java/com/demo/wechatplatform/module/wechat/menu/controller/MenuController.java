package com.demo.wechatplatform.module.wechat.menu.controller;

import com.demo.wechatplatform.module.wechat.menu.service.MenuService;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "/create")
    public void createMenu(){
        /**
         * ........menuService.create
         */
    }
}
