package org.everydayAlgorithm.forty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력된 수를 이진수로 변환하세요 (재귀)
17
정답: 10001
 */
public class No36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        toBinary(n, sb);

        System.out.print(sb.toString());
    }

    // 재귀로 이진수 출력
    public static void toBinary(int n, StringBuilder sb) {
        if (n < 2) {          // 더 이상 쪼갤 수 없으면
            sb.append(n);     // 마지막 비트 출력
            return;
        }

        toBinary(n / 2, sb);  // 앞자리 먼저 처리
        sb.append(n % 2);     // 마지막 자리 출력
    }
}
