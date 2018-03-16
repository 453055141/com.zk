package com.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
public class ZkCloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudEurekaServerApplication.class, args);
	}
}
