package org.basic.inherit;/*
 Today point
 상속관계에서 override : 상속관계에서 자식이 부모의 함수를 [재정의]
 [상속관계]에서 [자식클래스]가 [부모클래스]의 메서드를 재정의(내용을 바꿈  { ... 수정 })
 
 
 문법)
 1. 부모함수 이름 동일
 2. paramter  동일 , return type 동일
 3. 결국 { 안에 코드 수정 }

*/

class Point2{
	int x = 4;
	int y = 5;
	
	String getPosition() {
		return this.x + " / " + this.y;
	}
}

class Point3D extends Point2{
	int z = 6;
	
	
	//함수하나 추가 
	//String getPosition3D() {}
	
	//재정의
	@Override  //상속관계에서 컴파일러에게 코드 작성 문법에 대한 검사 (재정의 맞는지)
	String getPosition() {
		return this.x + " / " + this.y + " / " + this.z;
	
	}
	
}
    //Annotation 
	/*
	 어노테이션은 사전적 의미로는 주석이라는 뜻이다. 
	 자바에서 사용될 때의 어노테이션은 코드 사이에 주석처럼 쓰여서 특별한 의미, 
	 >>기능을 수행하도록 하는 기술이다. 
	 >>즉, 프로그램에게 추가적인 정보를 제공해주는 메타데이터(meta data: 데이터를 위한 데이터)라고 볼 수 있다.
	
	 1.컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공
     2.소프트웨어 개발툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보 제공
     3.실행시(런타임시)특정 기능을 실행하도록 정보를 제공
	*/
public class Ex04_Inherit_override {

	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println(p3.getPosition());
	}

}
