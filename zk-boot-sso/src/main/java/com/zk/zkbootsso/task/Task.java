package com.zk.zkbootsso.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Task {

    private Logger logger = LoggerFactory.getLogger(Task.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Async
//    @Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
//    public void oneTime(){
//        logger.info("第一个定时任务开始 "+dateFormat.format(new Date()));
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        logger.info("第一个定时任务结束 "+dateFormat.format(new Date()));
//    }
//
//    @Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
//    public void twoTime(){
//        logger.info("第二个定时任务 "+dateFormat.format(new Date()));
//    }

//    @Scheduled(cron = "0 07 20 ? * *" ) //使用cron属性可按照指定时间执行，本例指的是每天20点07分执行；
//    //cron是UNIX和类UNIX(Linux)系统下的定时任务
//    public void fixTimeExecution(){
//        System.out.println("在指定时间 "+dateFormat.format(new Date())+" 执行");
//    }

    //kafka定时任务
//        @Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
//    public void kafkaMessageSend(){
//            kafkaProducerConfig.sendMessage();
//    }
}
