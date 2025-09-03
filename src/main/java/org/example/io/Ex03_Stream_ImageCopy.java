package org.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
파일 경로를 설정하지 않으면 : 디폴트 경로는 이클립스 코드있는 곳에 생성됨

 */
public class Ex03_Stream_ImageCopy {
    public static void main(String[] args) {
        String oriFile = "D:\\Temp\\1.jpg";
        String targetFile = "D:\\Temp\\copy.jpg";

        FileInputStream fs = null;
        FileOutputStream fos = null;

        try {
            fs = new FileInputStream(oriFile);
            fos = new FileOutputStream(targetFile);

            int data = 0;
            while ((data = fs.read()) != -1) {
                fos.write(data); //copy.jpg에 write
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fs.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
