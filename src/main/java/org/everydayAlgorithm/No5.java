package org.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 대문자는 소문자로 소문자는 대문자로
예시 helloWorlD -> HELLOwORLd
배열, for, if 사용할 것
*/
public class No5 {

    private static boolean isStringUpperCase(String str) {
        if (!str.equals(str.toUpperCase())) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        String result = "";
        for(int i = 0; i < input.length; i++) {
            if(isStringUpperCase(input[i])) {
                result += input[i].toLowerCase();
            } else {
                result += input[i].toUpperCase();
            }
        }

        System.out.println(result);
    }
}
