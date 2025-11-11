package org.basic.util;

// 워드 5초간격으로 저장
// 주 스레드는 입력받기, 보조 스레드는 저장하기.
// 데몬 스레드는 “주 스레드가 살아있는 동안만” 존재한다 (메인 스레드 의존한다.)
class AutoSaveThread extends Thread {

    public void save() {
        System.out.println("작업 내용을 자동 저장 ....");
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                break;
            }

            save();
        }

    }
}


public class DaemonThread {

    public static void main(String[] args) {
        AutoSaveThread autosavethread = new AutoSaveThread();
        autosavethread.setDaemon(true);  //autosavethread 데몬 ....
        autosavethread.start();
        //main thread  종료 .... 데몬도 종료

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("메인 스레드 종료");
    }

}
