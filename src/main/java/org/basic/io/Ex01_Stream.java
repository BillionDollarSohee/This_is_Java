package org.basic.io;
/*
IO (Input/output)
Stream 시냇물 - 흐름이 한뱡항으로만 진행된다. (빨대통로)
= 데이터가 흘러가는 중간 매개체

1. 바이트가 통과할 수 있는 스트림 (디폴트) (이미지,file)
2. 캐릭터가 통과할 수 있는 스트림 (문자열데이터)

JAVA API 추상 클래스가 제공 되지만
입출력의 기본단위가 바이트이고 바이트배열로 넘긴다.

입력은 InputStream을 구현하고 있는 추상 클래스
출력은 OutputStream을 구현하고 있는 추상 클래스를 사용하면 된다.

내가 만약 바이트단위의 데이터를 입력 받고싶으면
InputStream을 상속, 구현하고 있는 클래스를 사용하면 된다.

입력을 하려는 대상
1. Memory : ByteArrayInputStream >> Array, Collection에서 그동안 써옴
2. File : FileInputStream
3. 네트워크간 작업

 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex01_Stream {
    public static void main(String[] args) {
        // FileInputStream
        // FileOutputStream

        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null; // 현재 메모리를 가지고 있지 않다.

        // Stream 2개 > memory > read > write

        ByteArrayInputStream input = null; // 통로 생성
        ByteArrayOutputStream outPut = null;

        input = new ByteArrayInputStream(inSrc);
        outPut = new ByteArrayOutputStream();

        System.out.println("soutSrc befefore :" + Arrays.toString(outSrc));

        // 공식 같은 로직(암기하기)
        int data;
        while ((data = input.read()) != -1) {
//            System.out.println(data);
            outPut.write(data); //자신의 통로에 가지고 있는거지 write대상이 data가 아님
        }
        outSrc = outPut.toByteArray(); //가지고있던 데이터를 바이트 배열로 바꿔서 내보내라
        System.out.println("outSrc after : " + Arrays.toString(outSrc));

        // read()는 next()를 포함하고 있다.
//        int data;
//        while ((data = input.read()) != -1) {
//            // System.out.println(data);
//            outPut.write(data); //자신의 통로에 가지고 있는거지 write대상이 data가 아님
//        }
//        outSrc = outPut.toByteArray(); //가지고있던 데이터를 바이트 배열로 바꿔서 내보내라
//        System.out.println("outSrc after : " + Arrays.toString(outSrc));
    }
}
