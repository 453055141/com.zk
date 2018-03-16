package com.zk.zkcloudfegin.service;

import org.springframework.stereotype.Component;

/**
 * @Author: zengkai
 * @Description:
 * @Date: Created in 2018/3/15 13:14
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
