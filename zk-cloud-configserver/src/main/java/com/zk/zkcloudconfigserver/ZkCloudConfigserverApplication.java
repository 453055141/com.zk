package com.zk.zkcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ZkCloudConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudConfigserverApplication.class, args);
	}
}
