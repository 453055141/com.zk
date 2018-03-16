package com.zk.zkbootcrawler.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * new的方法不能注入bean，注册此工具类，在无法利用注解注入的时候调用
 */
@Component
public class SpringApplicationContextHolder implements ApplicationContextAware{
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    public static ApplicationContext getContext(){
        return context;
    }
}
