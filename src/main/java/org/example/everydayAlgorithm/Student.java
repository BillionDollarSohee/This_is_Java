package org.example.everydayAlgorithm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private String no;

    Student(String name, String no) {
        this.name = name;
        this.no = no;
    }

}
