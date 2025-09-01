package org.example.oop;

/*
OOP 객체 지향 프로그래밍 ( 여러개의 작은 조각(설계도) 모아 모아서 큰 조각(큰 설계도) 행위

TIP) AOP : spring 고민 .... 주관심 보조관심을 분리 사용하는 방식


객체지향 프로그래밍 3대 요소
1. 상속 (재사용성)
2. 캡슐화(은닉화) : private ... setter , getter (간접할당)
3. 다형성 : 하나의 타입으로 여러개의 객체 주소를 가질 수 있는 것
          (상속관계에서 부모타입 변수는 상속을 받는 자식 객체의 주소를 가질 수 있다)

>> method >>  overloading   method
>> 하나의 이름으로 여러가지 기능을 하는 함수
  System.out.println()     println  이름 (함수 parameter 개수 , 타입)

   printChar() , printString() , printBoolean() >> (x)

   1. 오버로딩 사용 성능 (x)
   2. 편하게 사용할려고 , 개발자가 > 설계자가 ... 클래스를 사용하는 개발자를 배려 ....
   3. 오버로딩은 사용하지 않아도 문제 되지 않는다 .

 문법)
 1. 함수의 이름은 같고 parameter [개수] 와 [타입]
 1.1 함수의 이름 동일
 1.2 paramemter 개수 , 타입 다르면 된다
 1.3 return type 오버로딩의 판단 기준이 아니다
 1.4 parameter  순서가 다름을 인정
 ex) m(int i , String s)  , m(String s , int i)  오버로딩이야

*/

class Human{
    String name;
    int age;
}

class OverT{

    int add(int i) {
        return 100 + i;
    }

    int add(int i, int j) {
        return i + j ;
    }

    String add(String str) {
        return "hello" + str;
    }

    //int add (String s) {
    //	return 100;
    //}
    String add(int i , String s) { //순서가 다름을 인정
        return "hello" + s;
    }

    String add(String s , int i ) { //순서가 다름을 인정
        return "hello" + s;
    }
    // Today Point
    void add(Human human) { //참조타입
        human.age = 100;
        human.name = "홍길동";
    }

    void add(Human h , Human h2) {
        System.out.println("h : " + h + " h2 : " + h2);
    }
}

public class Method_Overloading {

    public static void main(String[] args) {
        OverT overt = new OverT();
        System.out.println(overt.add("A"));
        System.out.println(overt.add('A'));

        //overt.add(10.1f);
        //The method add(int) in the type OverT is not applicable for the arguments (float)

        //1. 초급
        Human h = new Human();
        overt.add(h);

        //2. 초급
        overt.add(new Human());

        Human h2 = new Human();
        overt.add(h, h2);
    }

}

