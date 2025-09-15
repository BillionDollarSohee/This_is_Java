package org.basic.inherit;/*
시나리오(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다
A라 전자제품 매장이 오픈되면

[클라이언트 요구사항]
가전제품은 제품의 가격 , 제품의 포인트 정보를 모든 제품이 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름정보를 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다 (ex) Tv , Audio , Computer
각각의 전자제품은 다른 가격정보를 가지고 있다( Tv:5000 , Audio : 6000)
제품의 포인트는 가격의 10%적용한다

시뮬레이션 시나리오
구매자: 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다
ex) 10만원 , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게 되면 가지고 있는 돈은 감소하고 (가격) 포인트는 증가한다
구매자는 처음 초기 금액을 가질 수 있다
*/

//전자제품의 공통사항 (모든 .... 가격 , 보너스포인트)
class Product {
	int price;
	int bonuspoint;
	
	//Product() {
		// TODO Auto-generated constructor stub
	//}
	Product(int price) {
			this.price = price;
			this.bonuspoint = (int)(this.price / 10.0);
	}
}

class KtTv extends Product{
	KtTv(){
		super(500);
	}
	
	@Override
	public String toString() {
		return "KtTv";
	}
}


class Audio extends Product{
	Audio(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product{
	NoteBook(){
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook";
	}
}

//구매자 
class Buyer{
	int money=2000;
	int bonuspoint;
	
	//KtTv , Audio , NoteBook
	/*
	void kttvBuy(KtTv n) { //n TV 정보 (가격 ,이름)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}
	void audioBuy(Audio n) { //n TV 정보 (가격 ,이름)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	void noteBookBuy(NoteBook n) { //n TV 정보 (가격 ,이름)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	...1000개 제품 구매 메서드 
	*/
	/*
	void Buy(KtTv n) { //n TV 정보 (가격 ,이름)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}
	void Buy(Audio n) { //n TV 정보 (가격 ,이름)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	void Buy(NoteBook n) { //n TV 정보 (가격 ,이름)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}
	
	...1000개 제품 구매 메서드 
	*/
	//개선
	void Buy(Product n) { //상속관계 부모타입의 참조 변수가 자식 객체의 주소를 받을 수 있다
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^" + this.money);
			return; //함수의 종료 (강제)
		}
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
	}

}
/*
 1차 오픈
 사장님 >> 하와이 휴가
 
 매장에서 제품을 더 구매 1000개 (마우스 , 토스트기 , 청소기) ... POS (자동 등록 : 제품)
 1000개 제품이 매장 배치
 
 주말 쇼핑 전단지 .....
 고객들이 ...
 난리 ...
 
 >> 팀장 >> 하와이 >> PC방 >> 전산망 > 개발 서버 > 2틀 밤새워 > 1000개의 추가 ... 
 
 문제1)
 즐거운 휴가를 보내기 위해서 아래 코드 수정 ....(제품이 늘어나도 ... 판매 가능하도록)
 




*/
public class Ex12_Inherit_KeyPoint_Poly {

	public static void main(String[] args) {
		// 매장 물건 전시
		KtTv kt = new KtTv();
		Audio audio = new Audio();
		NoteBook noteBook = new NoteBook();
		
		Buyer buyer = new Buyer();
		buyer.Buy(noteBook);
		buyer.Buy(noteBook);
		buyer.Buy(noteBook);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(audio);
		buyer.Buy(audio);
		/*
		buyer.noteBookBuy(noteBook);
		buyer.noteBookBuy(noteBook);
		buyer.noteBookBuy(noteBook);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.audioBuy(audio);
		buyer.audioBuy(audio);
		*/
	}

}
