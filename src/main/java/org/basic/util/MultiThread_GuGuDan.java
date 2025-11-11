package org.basic.util;

import javax.swing.JOptionPane;

public class MultiThread_GuGuDan {

    static boolean timeOut = false;

    public static void main(String[] args) {

        int totalCount = 0;   // 총 문제 수
        int correctCount = 0; // 정답 수

        Thread timer = new Thread(() -> {
            for(int i = 10; i > 0; i--){
                System.out.println("남은시간 : " + i);
                try { Thread.sleep(1000); } catch (Exception e){}
            }
            timeOut = true;
            System.out.println("시간 종료!");
        });

        timer.start();

        while(!timeOut) {  // 시간 끝날때까지 계속 문제!
            int dan = (int)(Math.random()*8)+2;
            int num = (int)(Math.random()*9)+1;
            int result = dan * num;

            String input = JOptionPane.showInputDialog(dan + " x " + num + " = ?");

            if(timeOut) break; // 입력도중 시간 종료 체크

            if(input == null || input.equals("")) continue;

            totalCount++;

            if(Integer.parseInt(input) == result){
                System.out.println("정답!");
                correctCount++;
            } else {
                System.out.println("오답!");
            }
        }

        // 여기서 최종 결과 출력
        System.out.println("========================");
        System.out.println("게임 종료");
        System.out.println("총 " + totalCount + "문제 중 " + correctCount + "문제 정답!");
        System.out.println("========================");
    }
}
