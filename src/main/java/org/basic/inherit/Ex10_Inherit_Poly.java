package org.basic.inherit;

/*
다형성(상속관계에서 존재)
다형성 : 여러가지 성질(상태) 를 가질 수 있는 능력

JAVA : 상속관계에서 하나의 참조변수(부모타입) 가 여러개의 타입(자식객체의 주소) 가질 수 있는 것
>> 하나의 참조 변수 >> 부모타입
>> 여러개의 타입   >> 부모를 상속 받는 자식 객체

*/
class Tv2{
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}

//자막 기능이 있는 Tv
class CapTv extends Tv2{
	
	//특수화 , 구체화
	String text;
	String captionText() {
		return this.text = "현재 자막 서비스 중입니다";
	}
}

public class Ex10_Inherit_Poly {
	public static void main(String[] args) {
		CapTv ct = new CapTv();
		ct.power();
		ct.chUp();
		System.out.println(ct.captionText());
		////////////////////////////////////////
		
		Tv2 tv2 = ct; 
		//상속관계 ... 
		//단 부모는 자신의 자원만 접근 가능
		//단 재정의는 제외하고 
		System.out.println(tv2.toString());
		System.out.println(ct.toString());

	}

}
