package com.zk.zkbootqueue.controller;

import com.zk.zkbootqueue.kafka.KafkaCustomerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息消费
 */
@RestController
public class CustomerController {

    @Autowired
    private KafkaCustomerConfig kafkaCustomerConfig;

    @RequestMapping("customermsg")
    @KafkaListener(topics = "test")
    public String customerMsg(String message, HttpServletRequest request, HttpServletResponse response){
    return message;
    }

}
