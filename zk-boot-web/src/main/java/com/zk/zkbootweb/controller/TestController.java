package com.zk.zkbootweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.zkbootweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private JedisCluster jedisCluster;

    @RequestMapping("finduserinfo")
    public String findUserInfo(HttpServletRequest request, HttpServletResponse response){
        String name = testService.finduserinfo(1);
        return name;
    }


    @RequestMapping("/setredis")
    public String setRedis(){
        jedisCluster.set("name","曾凯");
        String name = jedisCluster.get("name");
        return name;
    }

    @RequestMapping("/getprize")
    public String getPrize(){
        String prize = testService.getPrize(1);
        return prize;
    }

    @RequestMapping("/redis")
    public String redis(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","曾凯");
        map.put("age",27);
        JSONObject object = new JSONObject(map);
        jedisCluster.set("userinfo",object.toJSONString());
        String string = (String) jedisCluster.get("userinfo");
        return string;
    }

}
