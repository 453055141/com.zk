package com.zk.zkbootweb.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaCustomerConfig {

    private Gson gson = new GsonBuilder().create();

//    @KafkaListener(topics = "smsmessage")
//    public  void processMessage(String message){
//        System.out.println("kafka:"+message);
//    }
}
