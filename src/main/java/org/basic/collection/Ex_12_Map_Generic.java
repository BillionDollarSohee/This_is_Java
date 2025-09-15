package org.basic.collection;

import java.util.*;

class Student{
    int kor;
    int math;
    int eng;
    String name;

    public Student(int kor, int math, int eng, String name) {
        super();
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.name = name;
    }

    @Override
    public String toString() {
        return "No1_Student{name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + "}";
    }
}

class ArrayTest {
    ArrayList<String[]> al = new ArrayList<>();
}

public class Ex_12_Map_Generic {
    public static void main(String[] args) {
        HashMap<String, String> stm = new HashMap<>();
        stm.put("A","AAA");
        System.out.println(stm.get("A"));

        // No1_Student 객체 Map
        HashMap<String, Student> smap = new HashMap<>();
        smap.put("hong",new Student(100,43,50,"지수"));
        smap.put("lee",new Student(100,43,50,"왕수"));
        smap.put("kim",new Student(100,43,50,"공주"));
        System.out.println(smap.toString());

        // ArrayList<String[]> 테스트
        String[] strrr = {"A","B","H"};
        ArrayTest at =new ArrayTest();
        at.al.add(strrr);

        // Iterator 방식
        Set<Map.Entry<String, Student>> set = smap.entrySet();
        Iterator<Map.Entry<String, Student>> it = set.iterator();

        while (it.hasNext()) {
            Object obj = it.next();               // Object 타입으로 받음
            Map.Entry entry = (Map.Entry) obj;    // 다운캐스팅 (Object → Map.Entry)
            Student st = (Student) entry.getValue(); // 다운캐스팅 (Object → No1_Student)

            System.out.println(st.name + " / 국어: " + st.kor + " / 수학: " + st.math + " / 영어: " + st.eng);
        }

        // 방법 2 Entry class안에 오브젝트 키와 벨류가 있는데
        // Map안에 Entry[] elements 가 있어서 >> Map,Entry
        for (Map.Entry<String, Student> m : smap.entrySet()) {
            System.out.println(m.getKey() + " = " + m.getValue());
        }


    }
}
