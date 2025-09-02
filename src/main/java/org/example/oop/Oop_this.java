package org.example.oop;

/*
1. this = 객체 자신
   - 현재 생성된 객체 자신의 주소를 가리킴
   - 주로 인스턴스 변수와 지역 변수 구분,
     메서드 체인 또는 생성자 체인에서 사용

2. 생성자 호출 원칙
   - 객체를 생성할 때 생성자는 한 번만 호출됨
     ex) new Car(), new Car(10)

3. 예외: this() 사용
   - 한 생성자에서 다른 생성자를 호출 가능
   - 호출 위치: 반드시 생성자 첫 줄
   - 장점: 매개변수 개수/타입이 다른 생성자를 연결하여
           코드 중복 최소화
   - 실행 순서 예시:
       Zcar() 호출
         → this("red","auto",2") 호출
           → Zcar(String,String,int) 실행
         → Zcar()로 돌아와서 나머지 코드 실행
*/

class Test5{ //extends Object{
    int i;
    int j;

    Test5(){

    }
	/*
	유지보수 , 가독성, 단순 , 반복 ...
	Test5(int n , int k){
		i = n;
		j = k;
	}
	*/

    Test5(int i , int j){
        this.i = i;
        this.j = j;
    }
}

class Book2 {
    String bookName;

    //Book2(String name){
    //	bookName = name; //가독성 안좋아요
    //}
    Book2(String bookName){
        this.bookName = bookName;
    }
}

//Today Point
//생성자를 호출하는   this ( ***  중복 코드 감소 *** )

class Socar{
    String color;
    String gearType;
    int door;

    Socar(){ //기본 옵션
        this.color = "red";
        this.gearType = "auto";
        this.door=2;
    }

    Socar(String color , String gearType , int door){ //기본 옵션
        this.color = color;
        this.gearType = gearType;
        this.door=door;
    }

    void soCarPrint() {
        System.out.println(this.color + " , " + this.gearType + " , " + this.door);
    }
}

public class Oop_this {
    public static void main(String[] args) {

        Socar socar = new Socar(); //기본차량
        socar.soCarPrint();

        Socar socar2 = new Socar("gold", "auto", 6);
        socar2.soCarPrint();
    }

}
