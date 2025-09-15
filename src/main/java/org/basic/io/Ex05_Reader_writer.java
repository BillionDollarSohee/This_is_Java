package org.basic.io;

import java.io.FileReader;
import java.io.FileWriter;

/*
문자 기반의 데이터 다루기 (char > char[])
String 클래스는 내무적으로 char[] 관리

문자 추상 클래스
Reader, writer 추상클래스 >> Stream 붙어(Byte)

파일
FileReader, FileWriter
 */
public class Ex05_Reader_writer {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        String path = "D:\\Temp\\Ex01_Stream.java";

        try {
            fr = new FileReader(path);
            fw = new FileWriter("copy_Ex01.txt",true);
            int data = 0;
            while((data = fr.read()) != -1) {
                System.out.println(data);
                //일반 버전
//                fw.write(data);

                // 압축 버전 = 배포에 사용
                // 엔터 탭 공백은 파일에 쓰지 않겠다를 구현하라.
                if (data != '\n' && data != ' ' && data != '\r' && data != '\t') {
                    fw.write(data);
                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
