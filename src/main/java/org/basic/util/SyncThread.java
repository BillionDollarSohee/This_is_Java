package org.basic.util;

class Wroom {
    synchronized void openDoor(String name) {
        System.out.println(name + "님 화장실 입장 ^^");
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "사용 중" + i);
            if (i == 10) {
                System.out.println(name + "님이 💩");
            }
        }
        System.out.println("시원");
    }
}

class User extends Thread {
    Wroom wr;
    String who;
    
    User(String name, Wroom wr) {
        this.who = name;
        this.wr = wr;
    }
    
    @Override
    public void run() {
        wr.openDoor(this.who);
    }
}

public class SyncThread {
    public static void main(String[] args) {
        // 여기는 한강 화장실
        Wroom w = new Wroom();
        
        User kim = new User("김씨", w);
        User Lee = new User("이씨", w);
        User Park = new User("박씨", w);

        kim.start();
        Lee.start();
        Park.start();
    }
}
