package com.zk.zkbootweb.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    //当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@ResponseMapping
    @MessageMapping("/welcome")
    //当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public String say(ServerSocket serverSocket){
        //停1秒，让后台有时间去处理消息
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "欢迎"+serverSocket.getServermsg()+"!";
    }

}
