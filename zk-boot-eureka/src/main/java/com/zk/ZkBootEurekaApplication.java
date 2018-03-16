package com.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaServer
public class ZkBootEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkBootEurekaApplication.class, args);
	}
}
