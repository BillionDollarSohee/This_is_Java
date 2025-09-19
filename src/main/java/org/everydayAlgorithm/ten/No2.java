package org.everydayAlgorithm.ten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 : 피보나치 수열을 출력해라
An = An-1 + An-2
1 1 2 3 5 8 13 21 34
배열과 for문 이용할 것
 */
public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        if (input <= 0) {
            System.out.println(0);
        } else if (input == 1 || input == 2) {
            System.out.println(1);
        } else {
            int[] arr = new int[input];
            arr[0] = 1;  // 첫 번째 피보나치 수
            arr[1] = 1;  // 두 번째 피보나치 수

            for (int i = 2; i < arr.length; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[input-1]);
        }
        
    }

}
