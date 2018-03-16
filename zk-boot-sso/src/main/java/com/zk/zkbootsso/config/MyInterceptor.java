package com.zk.zkbootsso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisCluster jedisCluster;

    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionid = request.getRequestedSessionId();
        String uri = request.getRequestURI();
//        System.out.println(sessionid);
//        System.out.println(uri);
        Object value = jedisCluster.get(uri.replace("/","")+":"+sessionid);
        if(null!=value){
            return false;
        }
        jedisCluster.set(uri.replace("/","")+":"+sessionid,sessionid);
        System.out.println("进入prehandle");
        return true;
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String sessionid = request.getRequestedSessionId();
        String uri = request.getRequestURI();
        jedisCluster.del(uri.replace("/","")+":"+sessionid);
        System.out.println("postHandle被调用");
    }

    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion被调用");
    }
}
