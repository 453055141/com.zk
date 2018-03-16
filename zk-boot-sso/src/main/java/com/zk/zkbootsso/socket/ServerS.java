package com.zk.zkbootsso.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerS {

    public static void main(String[] args) {

            try {
                ServerSocket serverSocket = new ServerSocket(8888);
                Socket socket = serverSocket.accept();
                System.out.println("服务器启动，开始监听");
                // 读取客户端数据
                InputStream info = socket.getInputStream();
                DataInputStream dis = new DataInputStream(info);
                System.out.println("客户端说:"+dis.readUTF());

                // 向客户端输出数据
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF("Hello!连接成功");
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
