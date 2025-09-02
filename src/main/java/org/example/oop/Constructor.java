package org.example.oop;

/*
 생성자 함수 (constructor)
 1. 특수한 목적의 함수
 2. 목적 : member field 초기화 :  static {} , {}

 3. 일반 함수와 다른점
 3.1 함수 이름이 고정 ( class 이름 동일)
 3.2 return type 없어요 (void) (객체 생성과 동시에 호출) return 받을 대상이 없어요
 3.3 new Car > heap 객체 생성 > member feild 자리 > 초기화 생성자 함수 자동 호출
 3.4 return type(x) >> void >> public void(x) Car(){}  >> public Car(){}

 참고) 생성자 접근자 private  가능 (싱클톤 패턴) : 객체를 하나만 만들어서 공유

 4. 왜 만들까 : [생성되는 객체] 마다 [강제적]  으로 member field 초기화

 5. 생성자 함수 1개 만들수 있을까요
 5.1 아니요 > 생성자 함수 > overloading 사용하면 (강제 구현) >> TodayPoint
 *** 생성자 함수를 쓰는 가장 중요한 목적은 member field 강제적 초기화

 class Car {
    String color;
 }
 >> 설계도를 만든 사람은  자동차 색상은 니가 알아서 해 ( 안해도 어쩔 수 없어)

 class Car {
    String color="blue";
 }
 >> blue 이것을 다른 색상으로 .....

 문제) 자동차의 색상을 정하지 않고 출고
 출고 (반드시 어떤 색상은 강제로 정하게)

 class Car {
    String color;

    //public Car(){ //default (parameter (x))

    //}
    public Car(String data){ //overloading
    	color = data;
    }
 }

 Car c = new .... Car("blue");

*/


class Car{
    String carName="포니";
    //여러분이 강제적으로 구현하지 않는다면 default 생성자
    //컴파일러가 알아서 생성
    //생략  public Car() {}

    public Car() {
        System.out.println("나는 기본 생성자 함수");
        carName="내마음";
    }
}

class School{
    String schoolName="강남";
    //default 생성자 생략 (컴파일러가 자동 생성하는 구나) public School() {}
}

class Car2 {
    String carName;
}

class Car3 {
    String carName;
    public Car3() { //default constructor method
        carName = "포니"; //carName 초기화
    }
}

class Car4{
    String carName;
    public Car4() { //default
        carName="기본포니";
    }

    public Car4(String name) { //overloading (생성자)
        carName = name;
    }
    // Car4 사용하는 개발자에게 옵션 (default , overloading)
}

class Car5{
    String carName;
    //public Car5() { //default
    //	carName="기본포니";
    //}

    public Car5(String name) { //overloading (생성자)
        carName = name;
    }
    // Car4 사용하는 개발자에게 옵션 (default , overloading)
}

class Car7 {
    String carcolor;
    int door;
    public Car7() {
        carcolor="blue";
        door=4;
    }
    public Car7(int num) {
        carcolor = "blue";
        door = num;
    }
    public Car7(String color) {
        carcolor = color;
        door = 4;
    }
    public Car7(int num , String color) {
        carcolor=color;
        door = num;
    }
}

public class Constructor {

    public static void main(String[] args) {

        Car car = new Car(); //default 함수 호출
        System.out.println(car.carName);

        //car.move();

        Car4 car4 = new Car4("그랜져");
        System.out.println(car4.carName);

        Car5 car5 = new Car5("v6");

    }

}
