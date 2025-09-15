package org.basic.util;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Emp {

    private int empno;
    private String ename;
    private String job;
	
	public Emp(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}


    //재정의 가장 대표적인 사례
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", " + ", job =" + job + "]";
	}

	//다음코드는 1일 개발자 , 10년차 개발자 같은 코드...
	//Object toString() > 자식은 Emp 사용가능   > 조작된 주소값
}
