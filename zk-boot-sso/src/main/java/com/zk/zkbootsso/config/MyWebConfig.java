package com.zk.zkbootsso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截器
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这种方式无论什么情况都可以
        registry.addInterceptor(myInterceptor()).addPathPatterns("/session");
        //这种情况时，自定义的interceptor中不能注入其他内容，比如redis或者其他service，如果要注入，必须使用上面这种方法
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/session");
        super.addInterceptors(registry);
    }
}
