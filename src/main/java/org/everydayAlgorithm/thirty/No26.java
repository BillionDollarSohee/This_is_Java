package org.everydayAlgorithm.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;

public class No26 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // reverse를 람다로 정의
        IntUnaryOperator reverse = n -> {
            int r = 0;
            for (; n > 0; n /= 10) r = r * 10 + n % 10;
            return r;
        };

        System.out.println(Math.max(reverse.applyAsInt(a), reverse.applyAsInt(b)));
    }
}

/*
IntUnaryOperator는 Java의 함수형 인터페이스 중 하나로,
int → int로 매핑하는 함수”를 표현하는 타입이다

@FunctionalInterface
public interface IntUnaryOperator {
    int applyAsInt(int operand);
}
*/