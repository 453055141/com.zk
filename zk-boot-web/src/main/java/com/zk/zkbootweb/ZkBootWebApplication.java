package com.zk.zkbootweb;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnablePrometheusEndpoint//监控
//@EnableSpringBootMetricsCollector//监控
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

//@ComponentScan(basePackages = {"com.zk.zkbootmq.ActiveMq"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ZkBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkBootWebApplication.class, args);
	}
}
