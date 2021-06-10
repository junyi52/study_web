package com.stu.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {
    public static void main(String[] args) throws  Exception{
        DatagramSocket socket = new DatagramSocket(9999);
        while (true){
            //准备接受数据包
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);//阻塞式接受包裹

            //如果收到bye,断开连接
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, packet.getLength());
            System.out.println(receiveData);
            if (receiveData.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
