package org.everydayAlgorithm.forty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 0 -> 2
00000
00110
00001
00000
00100
*/
public class No33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                sb.append(c == '0' ? '2' : c);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
