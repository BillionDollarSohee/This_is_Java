package org.example.team1.lotto;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LottoApp_File {
    public static void main(String[] args) {
        Lotto_File lotto = new Lotto_File();
        int numOfTickets = 5;

//        String path = "D:\\Temp\\lotto.txt";
        String path = "C:\\Users\\lisso\\Desktop\\MSA\\Temp\\lotto.txt";

        try (FileOutputStream fos = new FileOutputStream(path);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            for (int i = 0; i < numOfTickets; i++) {
                // 6개 번호 생성 + 정렬
                int[] numbers = lotto.pickFiveRandomNumbers();
                lotto.bubbleSort(numbers);

                // 번호 출력 + 문자열 리턴
                String numbersStr = lotto.printRandNum();

                // 파일 저장
                bos.write(numbersStr.getBytes());
                bos.write(System.lineSeparator().getBytes()); //줄바꿈 담당
            }

            bos.flush();
            System.out.println("로또 결과가 파일에 저장되었습니다: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
