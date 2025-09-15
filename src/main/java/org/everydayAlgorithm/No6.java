package org.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");

        int[] input = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            input[i] = Integer.parseInt(parts[i]);
        }

        int big = Math.max(input[0], input[1]);
        int mini = Math.min(input[0], input[1]);

        System.out.println(GCD(big, mini));

    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
