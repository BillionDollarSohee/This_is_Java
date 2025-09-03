package org.example.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
출력 형식을 정의하는 보조 스트림 예시 트리그리기
1. printf
2. String.format()
3. I/O PrintWriter (파일에 출력 예쁘게) - 줄맞춤

현업 : 세금계산서, 지출결의서, 휴가원, 결제 서류...레포팅 툴로 크리스탈 레포트가 있다.

콘솔용 프린팅 작업 해주는 PrintWriter
 */
public class Ex11_PrintWriter {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("D:\\Temp\\homework.txt");
            pw.println("********************************************");
            pw.println("**                HOMEWORK                **");
            pw.printf("%3s : %5d %5d %5d %5.1f","아무개",100,88,90,(float)((100+88+90)/3));
            pw.println();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            pw.close();
        }

        pw.close();
    }
}
