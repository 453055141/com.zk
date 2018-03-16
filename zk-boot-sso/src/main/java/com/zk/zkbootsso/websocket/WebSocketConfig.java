package com.zk.zkbootsso.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//注解开启使用STOMP协议来传输基于代理(message broker)的消息,这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息。
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息
        config.enableSimpleBroker("/topic");
        //指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 这个方法的作用是添加一个服务端点，来接收客户端的连接
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个STOMP的endpoint,并指定映射指定的url,使用SockJS协议
        //表示添加了一个/socket端点，客户端就可以通过这个端点来进行连接
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}