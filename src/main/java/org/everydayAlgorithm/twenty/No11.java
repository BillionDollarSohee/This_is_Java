package org.everydayAlgorithm.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[][] arr = new int[input][input];
        int start = 1;
        for (int i = 0; i < input; i ++) {
            if( (i+1) %  2 == 0) {
                for (int j = input - 1; j >= 0; j--) {
                    arr[i][j] = start;
                    start++;
                }
            } else {
                for (int j = 0; j < input; j ++) {
                    arr[i][j] = start;
                    start++;
                }
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
