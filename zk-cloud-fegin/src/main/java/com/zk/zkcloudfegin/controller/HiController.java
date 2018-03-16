package com.zk.zkcloudfegin.controller;

import com.zk.zkcloudfegin.service.SchedualServiceHi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: zengkai
 * @Description:
 * @Date: Created in 2018/3/15 1:01
 */
@RestController
public class HiController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        logger.info("我是Fegin");
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
