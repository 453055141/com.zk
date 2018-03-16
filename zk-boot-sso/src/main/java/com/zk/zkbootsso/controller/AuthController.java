package com.zk.zkbootsso.controller;

import com.alibaba.fastjson.JSONObject;
import com.zk.zkbootexception.config.BusinessException;
import com.zk.zkbootexception.config.ReturnFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    @Autowired
    private JedisCluster jedisCluster;

    @RequestMapping("test")
    public Object findUserInfo(String test,HttpServletRequest request, HttpServletResponse response){
        int a = 5;
        int b =0;
//        int c = a/b;
//        if(5==a){
//            throw new BusinessException("测试");
//        }
        return ReturnFormat.retParam(0,a);
//        return ReturnFormat.retParam(2029,null);
//        return a/b;
    }

    @RequestMapping("/redis")
    public String redis(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","曾凯");
        map.put("age",30);
        jedisCluster.set("userinfo",map.toString());
        String string = jedisCluster.get("userinfo");
        return string;
    }

    @RequestMapping("/redisset")
    public String redisSet(String url){
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","曾凯");
//        map.put("age",30);
//        JSONObject object = new JSONObject(map);
        jedisCluster.sadd("urls",url);
        return "ok";
    }

    @RequestMapping("/session")
    public String session(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //获取session的Id
        String sessionId = session.getId();
        response.addHeader("Set-Cookie", "JSESSIONID=" + sessionId + ";HttpOnly;Secure");
        //判断session是不是新创建的
        if (session.isNew()) {
            System.out.println("session创建成功，session的id是："+sessionId);
        }else {
            System.out.println("服务器已经存在session，session的id是："+sessionId);
        }
        //验证反复提交
        Object oldtime = session.getAttribute("time");
        if(null!=oldtime){
            System.out.println("old:"+Long.valueOf(oldtime.toString())/1000);
            Long nowtime = System.currentTimeMillis()/1000;
            System.out.println("now:"+nowtime);
            long time = nowtime-Long.valueOf(oldtime.toString())/1000;
            System.out.println(time);
            if(2>time){
                System.out.println("1秒内重复提交");
            }
        }
        session.setAttribute("time", System.currentTimeMillis());
        //模拟程序执行0.5秒
        System.out.println("程序执行中");
        Thread.sleep(5000);
        System.out.println("执行完毕");
        return "执行完毕";
    }
}
