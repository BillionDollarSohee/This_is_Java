package org.example.inherit;


import org.example.util.Emp;

class Test2{
	int x = 100;
	
	void print() {
		System.out.println("부모함수  Test2");
	}
}

class Test3 extends Test2{
	int x = 300; // C# 부모 무시하기 (쓰지 마세요)
	
}

public class Ex05_Inherit_override {

	public static void main(String[] args) {
		Test3 test3 = new Test3();
		System.out.println(test3.x);
		
		Emp emp = new Emp(7788, "smith");
		System.out.println(emp); //.toString() 생략  //재정의 하지 않으면 ...
		System.out.println(emp.toString());

	}
	/*
	  class Object {
	  	public String toString(){
	  		return 패키지명 + "@" + 주소값 
	  	}
	  } 
	  
	  class Emp extends Object {
	  
	  } 
	  
	 */
}
