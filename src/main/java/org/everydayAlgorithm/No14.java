package org.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
입력된 숫자의 개수를 출력하라
입력: 421314218
정답:

0: 0
1: 3
2: 2
3: 1
4: 2
5: 0
6: 0
7: 0
8: 1
9: 0

 */
public class No14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] numCount = new int[10];

        for (int i = 0; i < input.length(); i++) {
            int current = Integer.parseInt(String.valueOf(input.charAt(i)));
            numCount[current] += 1;
        }
        
        // 출력
        for (int i = 0; i < numCount.length; i++) {
            System.out.println(i + ": " + numCount[i]);
        }
    }
}