package com.zk.zkcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZkCloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudZuulApplication.class, args);
	}
}
