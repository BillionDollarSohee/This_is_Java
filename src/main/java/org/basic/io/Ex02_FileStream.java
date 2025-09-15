package org.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
1차 프로젝트에서 바라는 것
데이터의 저장을 메모리로 (Array나 컬렉션으로 저장)
이러면 프로그램이 종료되면 데이터가 소멸됨

따라서 txt파일을 이용해서 영속적인 데이터로 만드는 것
파일을 읽으려면 규칙이 있어야 한다 -> ex> \n 이나 , 등등으로 한건씩 읽을 수 있게
은행에서 1억건의 거래를 DB로 하면 서버 죽음. 파일은 대량의 정보를 관리할 수 있어서 필요함

2차 프로젝트에서는 데이터 베이스를 써보기

Byte 데이터를 read/write 대상은 file (a.txt, memo.txt)
FileInputStream
FileOutPutStream

이미지, 엑셀 > read, write

I/O는 관리되지 않는 자원(힙만 관리하는 가비지컬렉터의 범위를 벗어나므로)
이므로 직접 자원을 관리해야한다. (엑셀 2번열면 읽기전용으로 열겠습니까? -> 지원해제가 안되어서)
내가 작업을 완료하면 그 자원에 대한 해제를 해야함 close();

해제할거라는 보장을 받기위해 (불안하므로) 예외처리를 강제하도록 하였음.
try - catch 문을 써야함 -> 강제되는 예외를 많이 만날 것 이다.

없는 파일을 열려고 하거나 권한이 없을 수 있으므로 방어적 코드를 만들기 위해서


FileOutputStream 내부에는 파일이 존재하지 않으면 자동생성해준다. create를 포함
내부에는 옵션이 있는데 두번째 파라미터를 추가가능 t/f
true - 뒤에 이어쓰기 /false(디폴트) - Overwrite 덮어쓰기

 */
public class Ex02_FileStream {
    public static void main(String[] args) {
        FileInputStream fs = null;
        FileOutputStream fos = null;

        String path = "D:\\Temp\\a.txt";

        try {
            fs = new FileInputStream(path);
            fos = new FileOutputStream("D:\\Temp\\new.txt");

            int data = 0;
            while ((data = fs.read()) != -1) {
                System.out.println("정수 : " + data + (char)data);
                fos.write(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        } finally {
            // 정상 종료든, 비정상 종료든 강제로 실행되는 블럭으로
            // 할수가 return 을 만나도 실행된다.
            try {
                fs.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
//                throw new RuntimeException(e);
            }
        }



    }
}
