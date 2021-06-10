package com.stu.test;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        //创建socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9990);
        //创建一个输出流
        OutputStream os = socket.getOutputStream();
        //读取文件

        FileInputStream fis = new FileInputStream(new File("a.jpg"));
        //写出文件
        byte[] bytes = new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        //通知服务器传输完毕
        socket.shutdownOutput();
        //确定服务器接受完毕,断开连接
        InputStream is = socket.getInputStream();
        //通过管道流进行转换
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[1024];
        int len1;
        while ((len1=is.read(bytes1))!=-1){
            byteArrayOutputStream.write(bytes1,0,len1);
        }
        System.out.println(byteArrayOutputStream.toString());
        //关闭资源
        byteArrayOutputStream.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
