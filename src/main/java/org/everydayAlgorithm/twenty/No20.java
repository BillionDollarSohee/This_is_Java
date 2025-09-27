package org.everydayAlgorithm.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
369 게임
정답:  1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 14 15 짝 17 18 짝 20 21 22 짝 24 25 짝 27 28 짝 짝
짝 짝 짝짝 짝 짝 짝짝 짝 짝 짝짝 40 41 42 짝 44 45 짝 47 48 짝 50 51 52 짝 54 55 짝 57 58 짝 짝
짝 짝 짝짝 짝 짝 짝짝 짝 짝 짝짝 70 71 72 짝 74 75 짝 77 78 짝 80 81 82 짝 84 85 짝 87 88 짝 짝
짝 짝 짝짝 짝 짝 짝짝 짝 짝 짝짝 100
 */
public class No20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("몇까지 할까요? (엔터만 누르면 기본값 100): ");
        String line = br.readLine();

        int input;
        if (line == null || line.trim().isEmpty()) { // 입력이 없거나 공백만 있을 때
            input = 100;
        } else {
            input = Integer.parseInt(line);
        }

        for (int i = 1; i <= input; i++) {
            String[] current = String.valueOf(i).split("");
            boolean clap = false; // 박수가 있었는지 체크

            for (int j = 0; j < current.length; j++) {
                switch (current[j]) {
                    case "3":
                    case "6":
                    case "9":
                        System.out.print("짝");
                        clap = true;
                        break;
                }
            }

            if (!clap) {            // 3,6,9가 없으면 숫자 출력
                System.out.print(i);
            }

            System.out.print(" ");  // 한 칸 띄우기
        }
    }
}

