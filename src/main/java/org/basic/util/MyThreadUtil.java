package org.basic.util;

import javax.swing.JOptionPane;

class WordTime extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            if(Main.inputCheck) return;
            try {
                System.out.println("남은 시간 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class WordInputThread extends Thread {
    @Override
    public void run() {
        String dan = "2";
        String inputData = JOptionPane.showInputDialog(dan + "단 값을 입력하세요");

        if (inputData != null && !inputData.equals("")) {
            Main.inputCheck = true;
        }
        System.out.println("입력 값 : " + inputData);
    }
}

class Main extends Thread {  // ★ Main 이 Thread

    static boolean inputCheck = false;

    @Override
    public void run() {
        // Main Thread의 run() 안에 다른 Thread 실행
        WordTime timer = new WordTime();
        timer.start();

        WordInputThread wordInputThread = new WordInputThread();
        wordInputThread.start();

        // main 함수가 word thread , time thread 를 기다린다
        try {
            // timer.stop()  없어졌어요 위험해요 개발자가 임의로 중단 X
            timer.join();          // main thread 가 timer thread 종료를 기다림
            wordInputThread.join(); // main thread 가 wordInputThread thread 종료를 기다림
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main Thread run 종료");
    }

    public static void main(String[] args) {
        Main m = new Main(); // Main 객체도 Thread가 됨
        m.start();           // run()으로 진입
    }
}

