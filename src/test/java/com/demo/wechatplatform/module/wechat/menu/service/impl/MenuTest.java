package com.demo.wechatplatform.module.wechat.menu.service.impl;

import com.demo.wechatplatform.module.wechat.menu.service.MenuService;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;

    @Test
    public void testCreateMenu(){
        /**
         * 构建菜单
         *菜单1 click
         *菜单2 url跳转百度
         *菜单3 {2个子菜单 }
         */
        List<WxMenu.WxMenuButton> list =new ArrayList();
        List<WxMenu.WxMenuButton> sublist =new ArrayList();
        WxMenu.WxMenuButton menu1 = new WxMenu.WxMenuButton();
        menu1.setType("click");
        menu1.setName("菜单1");
        menu1.setKey("menu1");

        WxMenu.WxMenuButton menu2 = new WxMenu.WxMenuButton();
        menu2.setType("view");
        menu2.setName("菜单2");
        //menu2.setUrl("http://www.baidu.com");
        menu2.setUrl("http://www.baidu.com");
        WxMenu.WxMenuButton menu3 = new WxMenu.WxMenuButton();
        menu3.setType("click");
        menu3.setName("菜单3");
        menu3.setKey("menu3");

        /****构建子菜单***/
        WxMenu.WxMenuButton menu3_1 = new WxMenu.WxMenuButton();
        menu3_1.setType("click");
        menu3_1.setName("菜单3-1");
        menu3_1.setKey("menu3_1");
        WxMenu.WxMenuButton menu3_2 = new WxMenu.WxMenuButton();
        menu3_2.setType("click");
        menu3_2.setName("菜单3_2");
        menu3_2.setKey("menu3_2");

        sublist.add(menu3_1);
        sublist.add(menu3_2);
        menu3.setSubButtons(sublist);

        list.add(menu1);
        list.add(menu2);
        list.add(menu3);
        WxMenu wxMenu=new WxMenu();
        wxMenu.setButtons(list);
        menuService.create(wxMpInMemoryConfigStorage,wxMenu);
    }

    @Test
    public void testDeleteMenu(){
        menuService.delete(wxMpInMemoryConfigStorage);
    }

}