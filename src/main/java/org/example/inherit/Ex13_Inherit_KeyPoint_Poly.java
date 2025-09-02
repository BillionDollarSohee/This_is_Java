package org.example.inherit;/*
문제 풀어 보세요 ^^
요구사항
 >> 매장카트 구현하기 입니다 <<
카트 (Cart) >> member field 
카트 매장에 있는 [모든 전자제품]을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... [카트에 담는다]
---------------------------------------
계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart  담는 것을 구현 )
hint) Buyer ..>> summary()  main 함수에서 계산할때  사용합니다

Buyer >> buy() , summary()  >> 카트에 물건 계산 (어떤물건 , 각 가격 >> 당신은 총 얼마 지급)

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
*/


//전자제품의 공통사항 (모든 .... 가격 , 보너스포인트)
class Product2 {
	int price;
	int bonuspoint;
	
	//Product() {
		// TODO Auto-generated constructor stub
	//}
	Product2(int price) {
			this.price = price;
			this.bonuspoint = (int)(this.price / 10.0);
	}
}

class KtTv2 extends Product2{
	KtTv2(){
		super(500);
	}
	
	@Override
	public String toString() {
		return "KtTv2";
	}
}


class Audio2 extends Product2{
	Audio2(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product2{
	NoteBook2(){
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook2";
	}
}

//구매자 
class Buyer2{
	
	//카드 만들고  ****//////////
	Product2[] cart; //다형성 (모든 제품) 단 전자제품 Product2 상속 
	int index=0;
	//////////////////////////
	
	Buyer2() {
		//기본값
		this(1000,0);
	}
	Buyer2(int money , int bonuspoint){
		//초기화
		cart = new Product2[10]; //10개 담을 수 있는 카드
		this.money = money;
		this.bonuspoint = bonuspoint;
	}
	
	
	int money=2000;
	int bonuspoint;
	
	void Buy(Product2 n) { //상속관계 부모타입의 참조 변수가 자식 객체의 주소를 받을 수 있다
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//cart 담는다 ****
		//방어적 코드
		if(this.index >= 10) {
			System.out.println("고객님 그만 사세요^^");
			return;
		}
		cart[index++] = n;  //cart[++index]
		
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
		
		
	}
	
	void summery() {
		//구매한 물건 총액
		//포인트 총액
		//구매한 물건 목록 
		int totalprice=0;
		int totalbonuspoint=0;
		String productlist=""; //문자열 누적(StringBuffer ...)
		
		/*
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] == null) break;
			
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist+= cart[i].toString()+ " ";
		}
		*/
		for(int i = 0 ; i < index ;i++) {
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist+= cart[i].toString()+ " ";
		}
		
		System.out.println("*************");
		System.out.println("구매한 물건 총액 : " + totalprice);
		System.out.println("포인트 총액 : " + totalbonuspoint);
		System.out.println("구매한 물건 : " + productlist);
	}

}
public class Ex13_Inherit_KeyPoint_Poly {

	public static void main(String[] args) {
		KtTv2 tv2 = new KtTv2();
		Audio2 audio2 = new Audio2();
		NoteBook2 notebook2 = new NoteBook2();
		
		Buyer2 buyer2 = new Buyer2(5000,0);
		
		buyer2.Buy(notebook2);
		buyer2.Buy(notebook2);
		buyer2.Buy(tv2);
		buyer2.Buy(tv2);
		buyer2.Buy(tv2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.summery();

	}

}
