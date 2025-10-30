package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력된 숫자까지 + - 를 차례대로 반복하시오
예제 입력: 9
출력 1+2-3+4-5+6-7+8-9
*/
public class No30 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            result.append(i);

            if (i == n) break;

            if (i % 2 == 1) result.append("+");
            else result.append("-");
        }

        System.out.println(result);

    }
}
