package org.basic.io;

import java.io.BufferedReader;
import java.io.FileReader;


public class Ex06_Reader_Writer_Buffer {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("\"D:\\Temp\\Ex01_Stream.java");
            br = new BufferedReader(fr);

            String line = "";
            for (int i = 0; (line = br.readLine()) != null; i++) {
                if (line.indexOf(';') != -1) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

/*
FileWriter fw = new FileWriter(lotto.txt,true);
BufferedWriter bw = new BufferedWriter(fw);
bw.write("로또");
bw.newLine(); // 엔터 처리
bw.write("1회차: 1, 3, 5, 7, 8");
bw.newLine();
bw.close(); // 꼭 닫아주기
System.out.println("파일 쓰기 완료!");
 */