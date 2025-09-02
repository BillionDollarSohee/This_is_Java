package org.example.everydayAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 문제
학생들의 정보를 저장하고, 검색했을 때 학번을 출력하는 프로그램
학생들을 ArrayList에 저장하고, 계속 검색을 원하면 y를 종료를 원하면 n을 누름
이름이 존재하면 학번을 출력
이름이 존재하지 않으면 없는 학생 이라고 출력

while, flog, ArrayList, for-each 사용
 */
public class No1 {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("소희", "3463");
        Student student2 = new Student("기현", "2355");
        Student student3 = new Student("가연", "4567");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        for (Student s : students) {
            System.out.println(s.getName());
            System.out.println(s.getNo());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            System.out.println("검색을 하고 싶으면 y, 종료하고 싶으면 n");
            String input = br.readLine();

            if (input.equalsIgnoreCase("y")) {
                System.out.println("검색할 이름을 입력하세요:");
                String name = br.readLine();
                boolean flag = false;

                for (Student s : students) {
                    if (s.getName().equals(name)) {
                        System.out.println("해당 학생의 학번은: " + s.getNo());
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    System.out.println("해당하는 학생이 없습니다.");
                }

            } else if (input.equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.println("시스템이 종료되었습니다.");

    }
}

