package org.example.io;
// cmd 처럼 명령어로 화면을 다루는 법

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Dir_Format {
    public static void main(String[] args) {
        File dir = new File("D:\\Temp");
        File[] fileAndForder = dir.listFiles(); // 폴더와 파일 모두

        for (int i = 0; i < fileAndForder.length; i++) {
            File file = fileAndForder[i];
            String name = file.getName(); // 폴더 or 파일명
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma");
            String attribute = ""; // 파일의 속성 (접근가능성, 읽기전용, 숨긴파일 등)
            String size = "";

            if(fileAndForder[i].isDirectory()) { // 폴더임
                attribute += "<DIR>";
            } else { // 파일
                size = file.length() + "byte";
                attribute = file.canRead() ? "R" : "";
                attribute = file.canWrite() ? "W" : "";
                attribute = file.isHidden() ? "H" : "";
            }

            System.out.printf("%s  %3  %10s  %s  \\n",
                    df.format(new Date(file.lastModified())),
                    attribute,
                    size,
                    name);
        }
    }
}
