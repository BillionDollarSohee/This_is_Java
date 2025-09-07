package org.example.everydayAlgorithm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class No1_Student {
    private String name;
    private String no;

    No1_Student(String name, String no) {
        this.name = name;
        this.no = no;
    }

}
