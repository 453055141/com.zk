package com.zk.zkbootcache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisClusterConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Value("${spring.redis.password}")
    private String password;

//    @Value("${spring.redis.timeout}")
    private int timeOut = 10000;

    @Value("${spring.redis.cluster.max-redirects}")
    private int redirects;


//    @Bean(name = "jedisCluster")
    @Bean
    public JedisCluster jedisCluster() {
        System.out.println("********集群节点链接*********");
        String[] serverArray = clusterNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort: serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(),Integer.valueOf(ipPortPair[1].trim())));
            System.out.println("***地址:"+ipPortPair[0].trim()+"***端口号:"+ipPortPair[1].trim());
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(200);
        config.setMaxIdle(50);
        config.setMinIdle(8);//设置最小空闲数
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        //Idle时进行连接扫描
        config.setTestWhileIdle(true);
        //表示idle object evitor两次扫描之间要sleep的毫秒数
        config.setTimeBetweenEvictionRunsMillis(30000);
        //表示idle object evitor每次扫描的最多的对象数
        config.setNumTestsPerEvictionRun(10);
        //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
        config.setMinEvictableIdleTimeMillis(60000);

        return new JedisCluster(nodes,timeOut,5000,7000,password,config);
    }

}