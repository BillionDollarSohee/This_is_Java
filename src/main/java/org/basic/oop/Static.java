package org.basic.oop;

/*
 static 초기화
 1. static variable   : 객체마다 같은 값을 공유할 거야
 2. instance variable : 생성되는 객체마다 다른 값을 가지게 하겠다

 두 자원은 default 값 (초기화 할 필요 없다)
*/

public class Static {
    public static void main(String[] args) {
        System.out.println(Test2.cv);
        System.out.println(Test2.cv2);

        //초기화(일반)
        Test2 test2 = new Test2();
        System.out.println(test2.iv);

    }
}

class Test2 {
    static int cv = 10; //초기화
    static int cv2; //default 0

    int iv = 9;

    //1. static 자원 초기화 블럭 static {}
    static {
        //실행되는 시점 : static int cv = 10; static int cv2; 메모리에 올라간 직후 자동 호출(실행)

        //** 조작된 표현이 가능 (제어문)**
        cv2 = cv+2222;
    }

    //일반 자원 (초기화) : 일반자원의 초기화 블럭 : 생성자함수화 기능이 겹쳐 .... (인기도가 )
    //  new Test2() >> heap 영역 만들어지고 member field 올라가고 자동으로  초기화 블럭 실행 { }
    {
        System.out.println("초기화 블럭이 실행");
        if(iv < 10) iv = 10000;
    }
}
