package org.basic.tesk.book;

import java.io.*;

public class BookDataInputStream {
    public static void main(String[] args) {
        String filename = "BookList.txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis);


            // 전부 읽어와서 변환
            Object BookLists = null;
            while ((BookLists = in.readObject()) != null) {
                System.out.println(((Book) BookLists).toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않아요");
        } catch (EOFException e) {
            System.out.println("끝 " + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일을 읽을 수 없어요");
        } catch (ClassNotFoundException e) {
            System.out.println("해당 객체가 존재하지 않아요");
        } catch (Exception e) {
            System.out.println("나머지 예외");
        } finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }
}
