package org.everydayAlgorithm.forty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/*
입력된 두 수까지의 합을 재귀로 구하시오
1 4
정답: 10
 */
public class No32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = Math.min(t[0], t[1]);
        int m = Math.max(t[0], t[1]);

        System.out.println(sum(n, m));
    }

    public static long sum(int n, int m) {
        if (n > m) return 0;
        return n + sum(n + 1, m); 
    }
}

