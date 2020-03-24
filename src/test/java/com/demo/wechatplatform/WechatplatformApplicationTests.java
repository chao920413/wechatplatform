package com.demo.wechatplatform;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatplatformApplicationTests {

    @Autowired
    private com.demo.wechatplatform.config.app app;
    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;
    @Test
    public void contextLoads() {
        System.out.println(wxMpInMemoryConfigStorage);
    }

}
