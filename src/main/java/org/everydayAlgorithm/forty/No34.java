package org.everydayAlgorithm.forty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀로 피보나치
public class No34 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long result = fibonacci(n);

        sb.append(result);

        System.out.print(sb.toString());
    }

    public static long fibonacci(int num) {
        if (num <= 1) return num;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
