package com.stu.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(9990);
        //监听客户端的请求
        Socket accept = serverSocket.accept();//阻塞式监听
        //获取输入流
        InputStream is = accept.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("b.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        //通知客户端接受完毕
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("接受完毕".getBytes());
        //关闭连接

        fos.close();
        is.close();
        accept.close();
        serverSocket.close();
    }
}
