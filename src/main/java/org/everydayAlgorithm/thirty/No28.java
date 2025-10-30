package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력받은 10진수를 n진수로 변환시키시오.
예제 입력: 19 16
출력 13
Java의 내장함수는 2진수 ~ 36진수까지 지원한다.
*/
public class No28 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int decimal = Integer.parseInt(input[0]); // 10진수 입력
        int base = Integer.parseInt(input[1]);    // 변환할 진수

        // 내장 함수 사용
        String result = Integer.toString(decimal, base).toUpperCase();

        System.out.println(result);
    }
}