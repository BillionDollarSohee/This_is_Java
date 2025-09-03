package org.example.io;

import java.io.File;

/*
자바는 파일을 가지고 있는 폴더(디렉토리)를 다루는 클래스가 있다.
C#에서는 파일을 다루는 클래스와 폴더를 다루는 클래스가 나뉘어져 있다.
자바에서는 이걸 구분하지 않았다.
파일(생성,수정,삭제) & 폴더(생성,수정,삭제) 작업을 할 수 있다.
>> a.txt 폴더 생성, 수정, 삭제, 정보 read

절대 경로 : C:\, D:\ ,D:\\Team\\a.txt
상대 경로 : 현재 파일 중심으로 > ../ , /   ..

 1. 파일 클래스는 다양한 정보를 취득할 수 있다.

 */
public class Ex07_File {
    public static void main(String[] args) {
        String path = "D:\\Temp\\file.txt"; // 만들어 둠

        File f = new File(path);
        System.out.println("파일 존재 여부 : " + f.exists());
        System.out.println("너 폴더니? " + f.isDirectory());
        System.out.println("너 파일이니? " + f.isFile());
        System.out.println("파일명 : " + f.getName()); // file.txt
        System.out.println("절대 경로 : " + f.getAbsolutePath());
        System.out.println("파일 크기 : " + f.length() + "byte");
        System.out.println("부모 경로 : " + f.getParent());
    }
}
