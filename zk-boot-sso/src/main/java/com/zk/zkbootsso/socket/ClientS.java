package com.zk.zkbootsso.socket;

import java.io.*;
import java.net.Socket;

public class ClientS {

    public static void main(String[] args) {

        try {
            //建立连接
            Socket socket = new Socket("localhost",8888);
            //获取输出流，发送信息
            // 向服务器端发送数据
            OutputStream os =  socket.getOutputStream();
            DataOutputStream bos = new DataOutputStream(os);
            bos.writeUTF("我是客户端，请求链接");
            bos.flush();

            // 接收服务器端数据
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println("服务器说："+dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
