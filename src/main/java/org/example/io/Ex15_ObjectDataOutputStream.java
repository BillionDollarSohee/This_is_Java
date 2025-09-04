package org.example.io;
/*
파일에서 직렬화로 작성하면
읽을때도 역직렬화를 이용해서 읽어야한다.

객체 타입의 통신을 하려면
객체를 >> 프로세스, 네트워크, 파일간에 통신을 하려면
직렬화, 역직렬화 과정이 필요하다.

직렬화 : 객체를 분해해서 줄을 세워 보내는 *과정* 자체가 직렬화
역직렬화 : 객체를 다시 조립하는 *과정*

모든 자원은 직렬화가 가능할까? No,
직렬화가 가능하려면 설계도에 implements Serializable가 붙어져 있어야 한다.
 */

import org.example.io.util.UserInfo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Ex15_ObjectDataOutputStream {
    public static void main(String[] args) {
        String filename = "UserData.txt"; // 객체를 직렬화해서 write할 것

        // 삼총사가 있어야 함
        FileOutputStream fos = null; //주스트림
        BufferedOutputStream bos = null; //성능을 위한 보조스트림
        ObjectOutputStream out = null; //직렬화
        
        try {
           fos = new FileOutputStream(filename); //create
           bos = new BufferedOutputStream(fos);
           out = new ObjectOutputStream(bos); //직렬화

            UserInfo user1 = new UserInfo("소희", "개발자", 358);
            UserInfo user2 = new UserInfo("왕수", "왕자", 33);
        
            // UserInfo 객체를 직렬화시켜서 파일에 쓰기
            out.writeObject(user1);
            out.writeObject(user2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // 역순으로 닫을 것
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
