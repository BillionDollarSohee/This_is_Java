package org.basic.inherit;/*
객체 한개만 가지고 놀면
this : 객체 자신을 가르키는 (this.empno, this.....)
this : 생성자를 호출하는  this (this(100,"red"))

상속
부모 , 자식

super(상속관계에서 자식이 부모 자원에 접근하는 주소) : 상속관계에서 부모에 자원 접근(super)

1. super : 상속관계에서 부모자원에 접근
2. super : 상속관계에서 부모의 생성자 호출

Tip)
C# base
JAVA : super

*/

class Base{
	String basename;
	
	Base(){
		System.out.println("부모의 기본 생성자");
	}
	Base(String basename){
		this.basename = basename;
		System.out.println("basename : " + this.basename);
	}
	
	void method() {
		System.out.println("부모  method");
	}
}

class Derived extends Base {
	String dname;
	Derived() {
		System.out.println("자식 클래스 기본 생성자");
	}
	Derived(String dname){
		
		//부모 생성자 호출 코드 
		super(dname);  //********  부모쪽도 생성자 호출
		
		this.dname = dname;
		System.out.println("dname : " + this.dname);
	}
	
	@Override
	void method() {
		System.out.println("부모 method 재정의");
	}
	
	//부모님 .... 그리워 .....
	//그리워 메서드 ..
	void parentMethod() {
		super.method(); // 부모 자원에 접근
	}
}


public class Ex06_Inherit_super {

	public static void main(String[] args) {
		//Derived d = new Derived();
		Derived d = new Derived("홍길동");
		d.method();
		d.parentMethod();
	}

}
