package org.everydayAlgorithm.forty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력된 수의 팩토리얼 구하기
입력:5  / 출력:120
재귀
 */
public class No31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(pactorial(n));
    }

    public static long pactorial(int input) {
        if (input <= 1) return 1;
        return input * pactorial(input - 1);
    }
}
