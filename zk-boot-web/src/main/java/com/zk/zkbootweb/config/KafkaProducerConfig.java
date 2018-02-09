package com.zk.zkbootweb.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@EnableKafka
public class KafkaProducerConfig {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void sendMessage() {
//        KafkaMessage m = new KafkaMessage();
//        m.setId(System.currentTimeMillis());
//        m.setMsg(UUID.randomUUID().toString());
//        m.setSendTime(new Date());
        kafkaTemplate.send("smsmessage", "我叫曾凯");
    }
//public void send() {
//    kafkaTemplate.send("my-replicated-topic", "xiaojf");
//    kafkaTemplate.send("my-replicated-topic", "xiaojf");
//
//    kafkaTemplate.metrics();
//
//    kafkaTemplate.execute(new KafkaOperations.ProducerCallback<String, String, Object>() {
//        @Override
//        public Object doInKafka(Producer<String, String> producer) {
//            //这里可以编写kafka原生的api操作
//            return null;
//        }
//    });
//
//    //消息发送的监听器，用于回调返回信息
//    kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
//        @Override
//        public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
//
//        }
//
//        @Override
//        public void onError(String topic, Integer partition, String key, String value, Exception exception) {
//
//        }
//
//        @Override
//        public boolean isInterestedInSuccess() {
//            return false;
//        }
//    });
//}
//    public Map<String, Object> producerConfigs () {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "119.23.106.184:9092");
//        props.put(ProducerConfig.RETRIES_CONFIG, 0);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
//        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        return props;
//    }

//    public ProducerFactory<String, String> producerFactory () {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }

//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate () {
//        return new KafkaTemplate<String, String>(producerFactory());
//    }

}
