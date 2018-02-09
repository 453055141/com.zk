package com.zk.zkbootweb.config;


import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyPageHelper {

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper() {
        PageHelper myPageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");      //配置mysql数据库的方言
        p.setProperty("supportMethodsArguments", "false");
        p.setProperty("pageSizeZero", "true");
        myPageHelper.setProperties(p);
        return myPageHelper;
    }
}
