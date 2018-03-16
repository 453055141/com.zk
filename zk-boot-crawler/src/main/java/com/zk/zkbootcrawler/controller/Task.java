package com.zk.zkbootcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Task {

    @Autowired
    private StartCrawler startCrawler;

    @Autowired
    private UrlAndRedis urlAndRedis;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
//    public void reportCurrentTime(){
//        System.out.println("每隔5秒执行一次 "+dateFormat.format(new Date()));
//    }

    @Scheduled(cron = "0 07 20 ? * *" ) //使用cron属性可按照指定时间执行，本例指的是每天20点07分执行；
    //cron是UNIX和类UNIX(Linux)系统下的定时任务
    public void fixTimeExecution(){
        System.out.println("在指定时间 "+dateFormat.format(new Date())+" 执行");
    }

    @Scheduled(fixedRate = 10000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
    public void startCrawlerProduction(){
        System.out.println("定时任务生产线程："+Thread.currentThread().getName());
        startCrawler.startCrawler();
    }

    @Scheduled(fixedRate = 15000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
    public void startCrawlerConsume(){
        System.out.println("定时任务消费线程："+Thread.currentThread().getName());
        urlAndRedis.urlSetRedis();
    }

}
