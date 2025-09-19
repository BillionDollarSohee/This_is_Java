package org.everydayAlgorithm.ten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력된 수의 각 자릿수 합을 구하시오
public class No9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            result += Integer.parseInt(input[i]);
        }
        System.out.println(result);
    }
}
