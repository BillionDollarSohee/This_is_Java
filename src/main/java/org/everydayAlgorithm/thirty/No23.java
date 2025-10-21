package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
입력된 문자열을 뒤집어서 출력하시오
입력 : ADEFH
정답: HFEDA
 */
public class No23 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String result = "";

        // 덱에 문자 하나씩 넣기
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addFirst(c);
        }

        for (char c : deque) {
            result += Character.toString(deque.removeFirst());
        }

        System.out.println(result);

    }
}
