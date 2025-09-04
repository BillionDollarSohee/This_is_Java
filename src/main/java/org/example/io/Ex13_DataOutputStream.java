package org.example.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
데이터를 출력할 때 타입을 지정해주는 *보조* 스트림

만약 니가 DataOutputStream을 쓰면 반드시 DataInputStream 로 입력받아야
데이터가 깨지지 않고 다뤄짐

예시로 성적.txt파일에 성적들을 라인으로 할지, 쉼표로 할지 규칙을 정해야함
라인단위로 버퍼 사용하고 split()으로 자르고 타입 변환하고 총합을 만들어야함

그래서 나온게 이거에요~!
 */
public class Ex13_DataOutputStream {
    public static void main(String[] args) {
        int[] score = {100, 60, 55, 95, 50};

        FileOutputStream fos = null; // 주 스트림
        DataOutputStream dos = null; // 보조 스트림 단독 사용 불가

        try {
            fos = new FileOutputStream("Score.txt"); // 파일생성
            dos = new DataOutputStream(fos); // 생성파일에 쓰기 담당

            for (int i = 0; i < score.length; i++) {
                dos.writeInt(score[i]); // 반드시 DataInputStream 을 사용해라
            }

            //채팅시 dos.writeUFT
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                dos.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
