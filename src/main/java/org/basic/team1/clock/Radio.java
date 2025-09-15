package org.basic.team1.clock;


public class Radio {
    final double[][] HERTZ = {
            {2.5, 5, 10, 15, 20},  // 미국
            {40, 60},              // 일본
            {3.33, 7.85, 14.67}    // 캐나다
    };

    int hour = 0;
    int minute = 0;
    int second =0;

    void HertzToTime(int Hertz) {
        for (int i = 0; i < HERTZ.length; i++) {
            for (int j = 0; j < HERTZ[i].length; j++) {
                if (Hertz == HERTZ[i][j]) {
                    hour = Hertz % 24;
                    minute = Hertz * 100 % 60;
                    second = Hertz * 10000 % 60;
                }
            }
        }
        System.out.println("현재 시간은 " + hour + ":" + minute + ":" + second + " 입니다.");
    }

}
