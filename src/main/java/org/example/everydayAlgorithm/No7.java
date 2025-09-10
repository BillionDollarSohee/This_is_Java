package org.example.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        if (isPrime(input)) {
            System.out.println(input + " 소수입니다.");
        } else {
            System.out.println(input + " 소수가 아닙니다.");
        }
    }

    static boolean isPrime (int num) {
        if (num < 2) return false;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
