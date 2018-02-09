package com.zk.zkbootweb.controller;

import com.alibaba.fastjson.JSONObject;
//import com.zk.zkbootcache.redisutils.RedisUtils;
import com.zk.zkbootutils.ZkTest;
import com.zk.zkbootweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

//    @Autowired
//    private RedisUtils redisUtils;

    @RequestMapping("finduserinfo")
    public String findUserInfo(HttpServletRequest request, HttpServletResponse response){
        String name = testService.finduserinfo(1);
        return name;
    }

//    @RequestMapping("utils")
//    public String utilsTest(HttpServletRequest request, HttpServletResponse response){
//        String name = ZkTest.sentMessage();
//        return name;
//    }

//    @RequestMapping("/setredis")
//    public String setRedis(){
//        redisUtils.set("name","曾凯".toString());
//        String string = (String) redisUtils.get("name");
//        return string;
//    }

    @RequestMapping("/getprize")
    public String getPrize(){
        String prize = testService.getPrize(1);
        return prize;
    }

//    @RequestMapping("/redis")
//    public String redis(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","曾凯");
//        map.put("age",27);
//        JSONObject object = new JSONObject(map);
//        redisUtils.set("userinfo",object.toJSONString());
//        String string = (String) redisUtils.get("userinfo");
//        return string;
//    }
}
