package com.zk.zkcloudeurekaserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zengkai
 * @Description:
 * @Date: Created in 2018/3/14 0:39
 */
@RestController
public class Controller {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
