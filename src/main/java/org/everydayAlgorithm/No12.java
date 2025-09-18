package org.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1  5  9 13
2  6 10 14
3  7 11 15
4  8 12 16
 */

public class No12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[][] arr = new int[input][input];
        int start = 1;
        int plus = 1;
        for (int i = 0; i < input; i ++) {
            for (int j = 0; j < input; j ++) {
                arr[i][j] = start;
                start += input;
            }
            start = 1;
            start += plus;
            plus++;
        }

        // 출력
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }

    }
}
