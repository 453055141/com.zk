package com.zk.zkbootmq.mq;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ActiveConsumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "my-queue1")
    @SendTo("out.queue") //为了实现双向队列.作用：将return的值返回到消息队列里
    public String receiveQueue1(String text) {
        if(StringUtils.isNotBlank(text)){
            System.out.println("receiveQueueOne收到的报文为:"+text);
            System.out.println("");
        }
        return "my-queue1"+text;
    }

    @JmsListener(destination = "my-queue2")
    @SendTo("out.queue") //为了实现双向队列
    public String receiveQueue2(String text) {
        if(StringUtils.isNotBlank(text)){
            System.out.println("receiveQueueTwo收到的报文为:"+text);
            System.out.println("");
        }
        return "my-queue2"+text;
    }
}
