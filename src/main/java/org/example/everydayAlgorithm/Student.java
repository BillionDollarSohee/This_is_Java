package org.example.everydayAlgorithm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private String no;

    Student(String name, String no) {
//        super(); // 왜 들어가지?
        this.name = name;
        this.no = no;
    }

}
