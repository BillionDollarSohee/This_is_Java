package org.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 : 10진수를 2진수로 변환
예시 : 19 -> 10011

풀이 1. Integer.toBinaryString() 메소드를 사용하여 변환가능
String binaryNumber = Integer.toBinaryString(decimalNumber);

풀이 2. while문으로 푸는 방법
10진수를 2로 나눕니다.
나누기 연산 후 나머지를 기록합니다.
나누기 연산의 몫을 가지고 다시 2단계로 돌아가 반복합니다.
몫이 0이 될 때까지 이 과정을 계속합니다.
기록했던 나머지들을 역순으로 나열하면 그것이 바로 2진수입니다.
 */
public class No4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        br.close();

        // 10진수가 0일 경우 예외 처리
        if (input == 0) {
            System.out.println("0");
            return;
        }

        StringBuilder binaryString = new StringBuilder();

        while (input > 0) {
            int remainder = input % 2;        // 2로 나눈 나머지를 저장합니다.
            binaryString.append(remainder);   // 나머지를 StringBuilder에 추가합니다.
            input /= 2;                       // 몫을 다음 반복에 사용합니다.
        }

        System.out.println(binaryString.reverse().toString()); // 나머지를 역순으로 출력합니다.

    }
}
