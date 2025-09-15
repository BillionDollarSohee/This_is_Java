package org.basic.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
파일 score.txt에 학생 점수가 기록되어있지만 읽기가 불가함 (깨져있어서)
read 해서 학생 점수 합계 / 평균을 내려고 함
 */

public class Ex14_DataInputStream {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("score.txt");
            dis = new DataInputStream(fis);

            while (true) {
                int score = dis.readInt(); // writeInt와 짝 맞춤
                System.out.println("score int data : " + score);
                sum += score;
                count++;
            }

        } catch (Exception e) {
            // EOFException 발생 시 while 종료됨
            System.out.println("총합 : " + sum);
            System.out.println("평균 : " + (sum / (double) count));
        } finally {
            try {
                if (dis != null) dis.close();
                if (fis != null) fis.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

