package org.basic.collection;

import org.basic.util.Message;

import java.util.Deque;
import java.util.LinkedList;

public class Ex_14_Queue {
    public static void main(String[] args) {
        Deque<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "김유신"));
        messageQueue.offer(new Message("sendKakaoTalk", "이순신"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();

            switch (message.getCommand()) {
                case "sendMail":
                    System.out.println(message.getTo() + "님에게 메일을 보냄");
                    break;
                case "sendSMS":
                    System.out.println(message.getTo() + "님에게 SMS를 보냄");
                    break;
                case "sendKakaoTalk":
                    System.out.println(message.getTo() + "님에게 카톡을 보냄");
                    break;
            }
        }
    }
}
