package org.everydayAlgorithm.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 입력값 n m을 받아서 n의 m제곱을 구하여라
* 5 3 -> 125
* */
public class No19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int result = 1;
        for (int i = 0; i < m; i++) {
            result *= n;
        }

        System.out.println(result);

    }
}
