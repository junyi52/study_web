package com.stu.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket ds = new DatagramSocket(9988);
        //接受数据包
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        //阻塞接受
        ds.receive(packet);
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0, packet.getLength()));
        //关闭连接
        ds.close();
    }
}
