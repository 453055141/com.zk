package com.zk.zkcloudtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zengkai
 * @Description:
 * @Date: Created in 2018/3/14 13:24
 */
@RestController
public class TestController {

    @RequestMapping("/haha")
    public String haha(){
        return "hahaha";
    }
}
