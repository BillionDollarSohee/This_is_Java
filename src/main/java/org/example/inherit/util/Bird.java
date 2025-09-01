package org.example.inherit.util;

//새 (공통: 일반 ,추상) : 새는 날수 있다 , 새는 빠르다
public class Bird {
	//공통기능
	public void fly() {
		System.out.println("flying");
	}
	//public void moveFast() {  
	//강제 ...
	protected void moveFast() //사용할려면 상속관계에서 재정의 ..사용해 강제
	{
	  fly();
	}
	/*
	
	class Bi extends Bird{
	
	}
	
	Bi bi = new Bi();
	bi.fly();
	//bi.moveFast();
	
	설계자 고민
	새는 빠르다
	fly
	새 : 타조 (달리기) 
	
	public 함수 재정의 했으면 좋겠어 ...
	강제성이 없어요 (상속)
	
	
	*/
}
