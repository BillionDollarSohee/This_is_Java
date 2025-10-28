package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력 n에 따른 달팽이 모양의 숫자를 출력하시오
예제 입력: 5

출력
1  2   3  4   5
16 17 18 19  6
15 24 25 20  7
14 23 22 21  8
13 12 11 10  9
 */
public class No27 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[][] arr = new int[length][length];

        swirl(arr, 0, length - 1, 1);

        // 출력
        for (int[] row : arr) {
            for (int v : row) {
                System.out.printf("%3d", v);
            }
            System.out.println();
        }

    }

    // 재귀함수로 가장자리 한바퀴 돌기
    static void swirl(int[][]arr, int start, int end, int num) {
        if (start > end) return;

        if (start == end) {
            arr[start][end] = num;
            return;
        }

        for (int i = start; i <= end; i++) arr[start][i] = num++;
        for (int i = start + 1; i <= end; i++) arr[i][end] = num++;
        for (int i = end - 1; i >= start; i--) arr[end][i] = num++;
        for (int i = end - 1; i > start; i--) arr[i][start] = num ++;

        swirl(arr, start + 1, end - 1, num);
    }
}