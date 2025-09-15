package org.basic.inherit;
/*
두개의 설계도

class Tv{}
class Vcr{}


*/

class Tv{
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power; //하나의 함수가 2개의 기능
	}
	
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
	
}

class Vcr{ //비디오 플레이어
	 boolean power;
	 
	 void power() {
			this.power = !this.power; //하나의 함수가 2개의 기능
	 }
	 
	 void play() {
		 System.out.println("재생하기");
	 }
	 void stop() {
		 System.out.println("정지하기");
	 }
	 void rew() {}
	 void ff() {}
}

/*
Tv , Vcr 합쳐진 전자제품

class TvVcr extends Tv , Vcr (x) 다중상속금지

1.계층적
누가 부모 , 누가 자식 고민

2. 둘다 포함
class TvVcr { Tv tv; Vcr vcr;}

3. 한놈은 상속하고 한놈은 포함 

메인 기능 (비중..)

*/

class TvVcr extends Tv {
	Vcr vcr;
	
	
	TvVcr(){
		this.vcr = new Vcr();
	}
	
	//TvVcr(Vcr vcr){
	//	this.vcr = vcr;
	//}
}

public class Ex03_Inherit {
   public static void main(String[] args) {
	 
	   TvVcr tvvcr = new TvVcr();
	   
	   tvvcr.power();
	   System.out.println(tvvcr.power);
	   
	   //비디오전원 
	   tvvcr.vcr.power();
	   System.out.println(tvvcr.vcr.power);
	   
	   
  }
}
