package com.stu.chat;

public class TeacherTalk {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666,"localhost",7777)).start();
        new Thread(new ReceiveSend(8888,"student:")).start();
    }
}
