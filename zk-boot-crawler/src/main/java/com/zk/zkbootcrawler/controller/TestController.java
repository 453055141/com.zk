package com.zk.zkbootcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

@RestController
public class TestController {
    @Autowired
    public JedisCluster jedisCluster;

    @RequestMapping("/redis")
    public Object redis(){
//        String string = jedisCluster.get("userinfo");
//        jedisCluster.sadd("urlgather","aaaaaa");
        long string = jedisCluster.scard("urlgather");
        return string;
    }

}
