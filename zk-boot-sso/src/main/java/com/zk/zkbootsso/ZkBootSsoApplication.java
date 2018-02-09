package com.zk.zkbootsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zk.zkbootpojo"})
public class ZkBootSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkBootSsoApplication.class, args);
	}
}
