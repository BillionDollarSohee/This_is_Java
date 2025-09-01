package org.example;

import org.example.TASK.Cinema;
import org.example.TASK.Emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

//        Cinema cinema = new Cinema();
//        cinema.start();

        Emp emp = new Emp(1000, "김유신");
        System.out.println(emp.toString());

        List empList = new ArrayList();
        //tostring 사용하지 않고 3명의 사원 정보 출력하기

        for (int i = 0; i < empList.size(); i++) {
            Object obj = empList.get(i);
            Emp e = (Emp)obj;
            System.out.println(e.getEmpno() + " / " + e.getEname());
        }

        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp(1, "소희짱"));
        for(Emp e : list) {
            System.out.println(e.getEmpno());
        }
    }
}
