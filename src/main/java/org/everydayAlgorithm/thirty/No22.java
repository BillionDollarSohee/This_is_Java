package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
        // 영숫자만 남기고 소문자로 통일
        String filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // 덱에 문자 하나씩 넣기
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : filtered.toCharArray()) {
            deque.addLast(c);
        }

        // 양쪽에서 하나씩 꺼내 비교
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
}
