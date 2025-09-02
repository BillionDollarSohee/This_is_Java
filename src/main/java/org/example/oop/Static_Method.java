package org.example.oop;

/*
  static member field : 객체간 공유자원
  static method : 객체간 공유자원

  1. 설계도
  1.1 static 자원 (변수 , 함수)

  -객체 생성 없이 사용 (메모리)
  -편하게 빠르게
  -** 많이 사용하니까 : System.out (static)
  - 자원을 많이 사용할 것 같아 .... new 없이
*/

class StaticClass {
    public static void main(String[] args) {
        StaticClass.print();

        StaticClass sc = new StaticClass();
        sc.printIv();
        System.out.println(sc.cv);

        sc.method();
        smethod();

    }

    int iv;
    static int cv;

    static void print() {
        System.out.println("static method");

    }

    void printIv() {
        //일반함수
        //StaticClass new  heap 메모리에 올라갔을때 사용가능

        //cv
        cv = 100; //순서상 ... static  올라가고 따라서 ...
    }
    //끼리 끼리 놀아라 ()
    //static 자원과 일반자원의 공생관계


    void method() {
        System.out.println("나 일반함수야");
    }

    static void smethod() {
        System.out.println("나 static 함수야");
    }
}








