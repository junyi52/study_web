package com.stu.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        //建立一个Socket
        DatagramSocket ds = new DatagramSocket();
        //建包
        String msg="Heloo World";
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port=9988;
        //数据,数据的长度起始,要发送给谁
        DatagramPacket packet=new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);
        //发送包
        ds.send(packet);
        //关闭流
        ds.close();
    }

}
