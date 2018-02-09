package com.zk.zkbootmq.ActiveMq;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ActiveConsumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "my-queue1")
    @SendTo("out.queue") //为了实现双向队列
    public void receiveQueue1(String text) {
        if(StringUtils.isNotBlank(text)){
            System.out.println("receiveQueueOne收到的报文为:"+text);
            System.out.println("");
        }
    }

    @JmsListener(destination = "my-queue2")
    @SendTo("out.queue") //为了实现双向队列
    public void receiveQueue2(String text) {
        if(StringUtils.isNotBlank(text)){
            System.out.println("receiveQueueTwo收到的报文为:"+text);
            System.out.println("");
        }
    }
}
