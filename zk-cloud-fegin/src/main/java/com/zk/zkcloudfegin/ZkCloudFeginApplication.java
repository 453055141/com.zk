package com.zk.zkcloudfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//仪表盘
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ZkCloudFeginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudFeginApplication.class, args);
	}
}
