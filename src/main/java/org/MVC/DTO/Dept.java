package org.MVC.DTO;
/*
데이터를 1건 담을 수 있는 객체
Oracle DB에 있는 Dept와 1:1 매칭되는 클래스로 만들 예정

new Dept();
-> select deptno, dname, loc from dept where deptno = 10;

List<Dept> list = new ArrayList<>();
-> select deptno, dname, loc from dept;
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private int deptno;
    private String dname;
    private String loc;
}
