package com.zk.zkcloudribbon.controller;

import com.zk.zkcloudribbon.server.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zengkai
 * @Description:
 * @Date: Created in 2018/3/15 0:40
 */
@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        logger.info("我是Ribbon");
        return helloService.hiService(name);
    }
}
