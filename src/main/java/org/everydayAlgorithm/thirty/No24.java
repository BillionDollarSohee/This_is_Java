package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력 7 100 95 90 80 70 60 50 출력 57.143%
public class No24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 숫자는 학생 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] score = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            sum += score[i];
        }

        double avg = (double) sum / n;

        int count = 0;
        for (int c : score) {
            if (c > avg) count++;
        }

        double result = (double) count / n * 100;
        result = Math.round(result * 1000) / 1000.0;
        System.out.println(String.valueOf(result + "%"));

    }
}
