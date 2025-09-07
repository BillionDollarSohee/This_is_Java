package org.example.everydayAlgorithm;
/*
문제 최빈수 구하기
예시 1 2 2 2 2 2 2 4 5 6 7 7 7 5 5 5 7 7 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8
결과 8
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();

        // 1. 문자열 배열을 정수 배열로 변환
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        // 2. 각 숫자의 빈도수를 세기 위한 배열
        // 입력 숫자가 0부터 10까지라고 가정하고 크기를 11로 설정합니다.
        int[] count = new int[11];
        for (int number : numbers) {
            if (number < count.length) {
                count[number]++;
            }
        }

        // 3. 최빈값과 최대 빈도수 찾기
        int mode = 0; // 최빈값을 저장할 변수
        int maxCount = 0; // 최대 빈도수를 저장할 변수

        // count 배열을 순회하며 가장 빈도수가 높은 숫자를 찾습니다.
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i]; // 최대 빈도수 업데이트
                mode = i;            // 최빈값 업데이트
            }
        }

        System.out.println(mode);

    }
}
