package org.everydayAlgorithm.forty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력된 수를 높은 자릿수 부터 출력하시오 (재귀로)
2312

정답:
2
3
1
2
*/
public class No35 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        printBigDight(s, 0, sb);
        System.out.println(sb.toString());
    }

    public static void printBigDight(String s, int index, StringBuilder sb) {
        if (index == s.length()) return;
        sb.append(s.charAt(index)).append("\n");
        printBigDight(s, index+1, sb);
    }
}
