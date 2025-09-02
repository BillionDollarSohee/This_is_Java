package org.example.collection;

import java.util.Properties;

/*
굳이 분류하자면 map을 구현한 interface로 특수한 목적을 가지고 있다.
이미 세팅된 제너릭이 <String, String>으로 고정되어 있다

사용처
1. App 전체에 사용되는 자원 관리
1-1 관리자 이메일 주소, 파일 업로드 경로 > 미리 만들어 놓음
1-2 Web > web.zml > 여러개의 페이지

2. 환경변수 만들때 전역적 의미로 사용
프로그램 버전, 공통변수
 */
public class Ex_13_Properties {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("admin","kosa@or.kr");
        prop.setProperty("version","1.0.2");
        prop.setProperty("downpath", "C:\\temp\\images");

        System.out.println("여러 페이지에서 사용 : " + prop.getProperty("admin"));
        System.out.println(prop.getProperty("downpath"));
    }
}
