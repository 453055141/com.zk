package com.zk.zkcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ZkCloudConfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkCloudConfigclientApplication.class, args);
	}

	@Value("${content}")
	String content;

	@RequestMapping("/")
	public String home() {
		return "content:" + content;
	}
}
