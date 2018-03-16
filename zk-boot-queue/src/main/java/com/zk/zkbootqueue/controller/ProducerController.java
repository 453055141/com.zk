package com.zk.zkbootqueue.controller;

import com.zk.zkbootqueue.kafka.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息生产
 */
@RestController
public class ProducerController {

    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    @RequestMapping("producermsg")
    public String producerMsg(String msg,HttpServletRequest request, HttpServletResponse response){
        kafkaProducerConfig.sendMessage("test",msg);
        return "OK";
    }
}
