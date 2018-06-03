//package com.zk.zkbootsso.controller;
//
//import com.zk.zkbootqueue.activemq.ActiveProducter;
//import org.apache.activemq.command.ActiveMQTopic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.jms.Destination;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class ActivemqController {
//
//    @Autowired
//    private ActiveProducter activeProducter;
//
//    @RequestMapping(value="/chufabaojing",method= RequestMethod.GET)
////    @ApiOperation(value="触发报警", notes="触发报警")
////    @ApiImplicitParams({
////            @ApiImplicitParam(name = "devicename", value = "name",example = "xxxx", required = true, dataType = "string",paramType="query"),
////    })
//    public String chufabaojing(String devicename){
//
//        List<String> alarmStrList = new ArrayList<>();
//        alarmStrList.add(devicename+":我叫曾凯");
//        alarmStrList.add(devicename+":我26岁");
//        alarmStrList.add(devicename+":我的电话18672537175");
//        alarmStrList.add(devicename+":我是单身");
//
//        System.out.println("设备"+devicename+"出围栏报警");
//        // 报警信息写入数据库
//        System.out.println("报警数据写入数据库。。。");
//
//        // 写入消息队列
//        Destination destination = new ActiveMQTopic("my-queue1,my-queue2");
//        for (String alarmStr : alarmStrList) {
//            activeProducter.sendMessage(destination, alarmStr);
//        }
//
//        // 消息写进消息队列里就不管了
//
//        // 下面两步骤移到activemq消费者里
//        // 发送邮件
//        // 发送短信
//
//        return "success";
//    }
//}
