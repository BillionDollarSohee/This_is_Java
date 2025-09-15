package org.basic.inherit;/*
private
default (같은 폴더 package)
public
상속관계에서 protected

protected 양면성 >> default , public

>> 상속이 없는 클래스 멤버필드  protected >> default 동일
>> 결국 상속관계에서만 의미 >> public

protected : 진정한 의미 (함수) : 재정의를 했느면 좋겠어 ... 그래야 니가 사용할 수 있어

*/
import org.basic.util.Pclass;
class Dclass {
	public int i;
	private int p;
	int s; //default
	protected int k; //상속(x) default 
}

class Child2 extends Pclass {
	
	void method() {
		this.k = 100; //상속관계에서는 protected > public 처럼
		System.out.println(this.k);
	}
	
	//protected : 진정한 의미 (함수) : 재정의를 했느면 좋겠어 ... 그래야 니가 사용할 수 있어
	//c2 참조변수가 함수 ....
	//재정의 강제한다 *****************
	@Override
	public void m() {
		System.out.println("재정의");
		//super.m();
	}
	
}
public class Ex08_Inherit_Protected {
	public static void main(String[] args) {
		Pclass p = new Pclass();
		p.i=100;

		Child2 c2 = new Child2();
		c2.method();
		c2.m();
	}

}
