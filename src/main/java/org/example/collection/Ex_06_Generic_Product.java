package org.example.collection;

import org.example.util.Emp;

import java.util.ArrayList;
import java.util.List;

public class Ex_06_Generic_Product {
    public static void main(String[] args) {
        Product[] cart = new Product[3];
        cart[0] = new Audio();
        cart[1] = new Audio();
        cart[2] = new Audio();


       List<Emp> person = new ArrayList<Emp>();
       person.add(new Emp(1000,"소희"));
        person.add(new Emp(2000,"왕수"));

        for (Emp e : person) {
            System.out.println(e.getClass().getName());
//            System.out.println(e.getEname());
        }

//        for (int i = 0; i < person.size(); i++) {
//            System.out.println(person.get(i).getEmpno());
//            System.out.println(person.get(i).getEname());
//        }
    }
}
