package org.example.everydayAlgorithm;

import java.util.*;
import java.lang.*;
import java.io.*;

class No8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        long result = factorial(num);
        System.out.println(result);

    }

    public static long factorial(long num) {
        if(num == 0) return 1;
        return num * factorial(num-1);
    }

}
