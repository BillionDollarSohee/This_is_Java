package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No28 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            result.append(i);

            if (i == n) break;

            if (i % 2 == 1) result.append("+");
            else result.append("-");
        }

        System.out.println(result);

    }
}