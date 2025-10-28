package org.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 스트림 생성하기
public class Ex06_Stream {
    public static void main(String[] args) {
        // 리스트로 부터 스트림 생성
        List<String> words = Arrays.asList("a", "b", "c");
        Stream<String> ex1 = words.stream();

        // 배열로부터 스트림 생성
        Stream<String> ex2 = Stream.of("A","B","C");
        Stream<String> ex3 = Stream.of(new String[] {"A","B","C"});
        Stream<String> ex4 = Arrays.stream(new String[] {"A","B","C"});

        /*
		  [ 원시 Stream 생성 ]
		  위와 같이 객체를 위한 Stream 외에도 int와 long 그리고 double과 같은 원시 자료형들을 사용하기 위한
		  특수한 종류의 Stream(IntStream, LongStream, DoubleStream) 들도 사용할 수 있으며,
		  Intstream같은 경우 range()함수를 사용하여 기존의 for문을 대체할 수 있다.
		*/
        IntStream ex5 = IntStream.range(4,10);
        ex5.forEach(System.out::println);

    }
}
