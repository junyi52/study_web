package com.stu.chat;

public class StudentTalk {
    public static void main(String[] args) {
        new Thread(new TalkSend(9999,"localhost",8888)).start();
        new Thread(new ReceiveSend(7777,"teacher:")).start();
    }
}
