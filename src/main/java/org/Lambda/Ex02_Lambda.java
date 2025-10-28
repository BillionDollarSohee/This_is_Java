package org.Lambda;

import java.util.ArrayList;
import java.util.List;

/*
람다식은 함수를 하나의 식으로 표현한 것이다.
자바에서 람다식을 사용하기 위해서는 함수형 인터페이스를 사용해야한다.
자바에서는 함수 1개만 사용할수가 없다.
이말을 함수를 쓰기 위해서 클래스를 만들고 객체로 만들어서 사용해야한다는 뜻으로
자바스크립트처럼 함수만 사용할 수 있게끔 고민을 해서
[단 하나의 추상 메소드]만 선언된 인터페이스를 만들었다.

Function MyFunc {
    int max(int x, int y);
}

익명 클래스. 익명객체 선언을 통해서
인터페이스가 1개의 추상 자원만 가지고 있다면 (여러개가 있다면 불가)
인터페이스를 구현체로 객체 생성이 구현이 가능하게 했다.

MyFunc = new MyFunc() {
    int max(int x, int y) {return a > b ? a : b; }
}

원칙은 OOP를 따라서
class Func implements MyFunc { public int max(){...} }
int value = f.max(3,5);

람다식의 장점
코드간결, 가독성증가, 병렬 프로그래밍 가능

단점
람다를 사용하면 무명함수는 재사용 불가능
추상화 때문에 디버깅이 어렵다
재귀적 구현이 어렵다

자바에서 자바 스크립트처럼 함수를 사용하기 위한 방법
함수적 인터페이스를 만들어서 해결
@FunctionalInterface // 진짜 인터페이스 안에 함수가 1개만 있는지 검사

 */
@FunctionalInterface
interface MyLambdaFunction {
    int max(int a, int b);
}

public class Ex02_Lambda {
    public static void main(String[] args) {

        // 익명객체, 익명함수
        System.out.println(new MyLambdaFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        }.max(3,5));

        // 람다식
        MyLambdaFunction lambdaFunction = (int a, int b) -> a > b ? a : b;
        System.out.println(lambdaFunction.max(3,5));


        // 예시 2
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c");
        list.add("react");

        for (String str : list) {
            System.out.println(str);
        }

        // 점점 줄여보기
        list.stream().forEach((String str) -> {System.out.println(str);});
        list.stream().forEach(str -> {System.out.println(str);});
        list.stream().forEach(System.out::println);
        list.forEach(System.out::println);
    }
}
