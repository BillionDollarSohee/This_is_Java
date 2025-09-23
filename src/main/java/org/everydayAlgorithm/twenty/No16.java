package org.everydayAlgorithm.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 별찍기 */
public class No16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String star = "*";
        for (int i = 0; i < n; i ++) {
            System.out.println(star);
            star += "*";
        }
    }
}
