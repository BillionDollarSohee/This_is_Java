package org.example.team1.book;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class BookDataOutStream {
    public static void main(String[] args) {

        String filename = "BookList.txt"; // 객체를 직렬화해서 write할 것

        // 삼총사가 있어야 함
        FileOutputStream fos = null; //주스트림
        BufferedOutputStream bos = null; //성능을 위한 보조스트림
        ObjectOutputStream out = null; //직렬화

        try {
            fos = new FileOutputStream(filename); //create
            bos = new BufferedOutputStream(fos);
            out = new ObjectOutputStream(bos); //직렬화

            Book book1 = new Book(6215L, "이것이 자바다", new BigDecimal("32000"));
            Book book2 = new Book(2515L, "토비의 스프링", new BigDecimal("54500"));

            // UserInfo 객체를 직렬화시켜서 파일에 쓰기
            out.writeObject(book1);
            out.writeObject(book2);
            out.writeObject(book1);

            System.out.println("직렬화 성공~!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                out.close();
                bos.close();
                fos.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
