package org.example.io;

import org.example.io.util.UserInfo;

import java.io.*;

public class Ex16_ObjectDataInputStream {
    public static void main(String[] args) {
        String filename = "UserData.txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis);

//            // 복원 - 개수를 알고 있어서 2개만 읽음
//            UserInfo u1 = (UserInfo) in.readObject();
//            UserInfo u2 = (UserInfo) in.readObject();
//
//            System.out.println(u1.toString());
//            System.out.println(u2.toString());

            // 전부 읽어와서 변환
            Object users = null;
            while ((users = in.readObject()) != null) {
                System.out.println(((UserInfo) users).toString());
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
