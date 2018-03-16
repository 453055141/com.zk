package com.zk.zkcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZkCloudEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudEurekaserverApplication.class, args);
	}
}
