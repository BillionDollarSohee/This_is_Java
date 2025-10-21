package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
더하기 사이클
N이 주어졌을 때 N 의 사이클의 길이를 구하시오 (1 ≤  N ≤ 100)
입력 26 정답 4, 입력 3 정답 60, 입력 24 정답 20

26 → 2 + 6 = 8 → 68
68 → 6 + 8 = 14 → 84
84 → 8 + 4 = 12 → 42
42 → 4 + 2 = 6 → 26
 */
public class No25 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        arr[0]= n;
        int count = 0;

        do {
            arr[2] = arr[0]/10;
            arr[3] = arr[0]%10;
            arr[4] = (arr[2] + arr[3]) % 10;
            arr[0] = arr[3] * 10 + arr[4];
            count++;
        } while (arr[0] != n);

        System.out.println(count);

    }
}
