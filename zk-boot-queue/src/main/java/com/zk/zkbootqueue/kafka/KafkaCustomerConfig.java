package com.zk.zkbootqueue.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaCustomerConfig {

//    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = "test")
    public  void processMessage(String message){
        System.out.println("kafka:"+message);
    }
}
