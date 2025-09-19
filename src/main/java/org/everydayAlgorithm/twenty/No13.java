package org.everydayAlgorithm.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1  2  3  4
2  4  6  8
3  6  9 12
4  8 12 16
 */

public class No13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[][] arr = new int[input][input];

        for (int i = 0; i < input; i ++) {
            for (int j = 0; j < input; j ++) {
                arr[i][j] = (i + 1) * (j + 1);
            }
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

