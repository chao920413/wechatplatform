package com.demo.wechatplatform.module.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class InitController {

    /**
     * 跳转入口
     * @return
     */
    @RequestMapping(value = "/init")
    public String initWeb (){
        return "success visit custom web";
    }
}
