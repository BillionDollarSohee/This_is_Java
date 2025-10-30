package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No29 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = true;
        boolean desc = true;

        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) desc = false;      // 앞보다 큰 경우엔 더 이상 내림차순이 아님
            else if (arr[i] > arr[i + 1]) asc = false;  // 앞보다 작은 경우엔 더 이상 오름차순이 아님
        }

        if (asc) System.out.println("ascending");
        else if (desc) System.out.println("descending");
        else System.out.println("mixed");

    }
}