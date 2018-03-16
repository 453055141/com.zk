package com.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnablePrometheusEndpoint//监控
//@EnableSpringBootMetricsCollector//监控
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.zk.zkbootcache","com.zk.zkbootutils"})
//@ComponentScan(basePackages = {"com.zk.zkbootmq.ActiveMq"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ZkBootWebApplication{

	public static void main(String[] args) {
		SpringApplication.run(ZkBootWebApplication.class, args);
	}
}
