package com.zk.zkcloudtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZkCloudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudTestApplication.class, args);
	}
}
