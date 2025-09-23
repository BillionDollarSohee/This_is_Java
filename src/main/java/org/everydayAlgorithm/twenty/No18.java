package org.everydayAlgorithm.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String star = "*";
        String blank = " ";
        for (int i = 0; i < n; i ++) {
            for (int k = 0; k < n - i; k++) {
                System.out.print(blank);
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print(star);
            }
            System.out.println();
        }

    }
}
