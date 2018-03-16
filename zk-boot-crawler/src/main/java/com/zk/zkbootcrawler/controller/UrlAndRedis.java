package com.zk.zkbootcrawler.controller;

import com.zk.zkbootcrawler.config.MyCrawler;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class UrlAndRedis {

    @Autowired
    private JedisCluster jedisCluster;

    @Autowired
    private MyCrawler myCrawler;

    public void urlSetRedis(){
        try {
//            String url = myCrawler.concurrentLinkedQueue.take();
            System.out.println("redis消费队列: ");
//            if(StringUtils.isNotBlank(url)){
//                //存入redis
//                jedisCluster.sadd("urlgather",url);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
