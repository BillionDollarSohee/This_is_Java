package org.basic.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
file 처리 대상이 disk이고 입출력 단위가 1 byte씩인것이 효율적이지 않음
여러명의 학생을 1명씩 태워서 목적지에 보내는 것이 아니고
여러명이 탈 수 있는 버스를 대여해서 한번에 보내는 것

버스 = 버퍼
1. 목적 = IO성능을 개선하겠다. = 접근횟수를 줄이겠다.
2. line단위로 처리가 가능하다. (엔터가 기준으로 한줄이라는 기준이 존재)

웹서버가 페이지를 클라이언트에세 전달할 때 (Buffer 8k byte 가 차면 반복적으로 보냄)

buffer 보조 (주연이 없으면 의미가 없음)
BufferedInputStream / BufferedInputStream 주연

>> Buffered 독자적 생성 불가
 */
public class Ex04_Stream_Buffer {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null; // 생성자에 주연을 강제시킴 = 기본 생성자가 없음

        String path = "D:\\Temp\\data.txt";

        try {
            fos = new FileOutputStream(path); // 없으면 자동생성
            bos = new BufferedOutputStream(fos); // 내가 너를 도와줄게

            for (int i = 0; i < 10; i++) { // 버스에 태워보냄
                bos.write('A');
            }
            // 결과 비어있음 why? 다 채워져야 출발해서 버퍼에 머금고 있음
            // 직접 보내주는 플러시를 하기위해 클로즈할수있음.
            // 근데 귀찮으니까 클로즈 안에 플러시를 넣어줄게.
            bos.flush(); // 8킬로바이트가 차지 않았을 때 강제 출발시킨다.

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
