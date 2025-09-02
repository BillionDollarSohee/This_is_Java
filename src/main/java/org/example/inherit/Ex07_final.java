package org.example.inherit;/*
변수 < - > 상수
상수: 한번 값이 [초기화] 되면 변경 불가
상수: 고유값 > 주민번호 ,  수학 : PI=3.141591... , 소프트웨어 출시(버전 v1.0.0.1)

상수 관용적으로 대문자 약속
JAVA : final int NUM=0;
C#   : const integer NUM=0;

final 키워드
1. final class Car {} >> 상속금지 
ex) public final class Math extends Object

2. public final void print(){ } >> 상속관계에서 재정의 금지
*/
import org.example.util.Apt;

class Vard {
	final String KIND="heart";
	final int NUM=10;
	
	void method() {
		//JAVA API 
		 System.out.println(Math.PI);
	}
}

//설계자 입장에서 ..
//카드를 만드는 설계도 .... (카드마다 모양 , 번호 한번 정해지면 변경 불가)

class Card {
	final String KIND;
	final int NUM;
	
	//Card(){}
	
	Card(String kind , int num){ //상수 초기화 보장 .. 코드 



this.KIND = kind;
		this.NUM = num;
	}
	
	@Override
	public String toString() {
		return "kind : " + this.KIND + " / " + "NUM : " + this.NUM;
	}
}


public class Ex07_final {
	public static void main(String[] args) {
		Card card1 = new Card("spade", 1);
		System.out.println(card1.toString());
		
		Card card2 = new Card("spade", 2);
		System.out.println(card2.toString());
		
		Card card3 = new Card("spade", 3);
		System.out.println(card3.toString());
		
		//card3.KIND = "aaa";
		//Math.PI   >> 상수 모든 객체 동일한 값을 >> final >> static final 
		
		Apt apt = new Apt();
		apt.setDoor(1000);
		System.out.println(apt.getDoor());
	
	}
}
