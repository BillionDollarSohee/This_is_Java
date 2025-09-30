package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1~100까지의 숫자가 띄어쓰기를 두고 입력 될 때 한번이라도 입력되었으면 중복이 없게끔 출력하라
입력 1 2 3 1 1 2 3 4 5 5
출력 1 2 3 4 5
 */
public class No21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        System.out.println(Arrays.toString(set.toArray()));

    }
}
