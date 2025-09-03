package org.example.io;

import java.io.*;

/*
파일안에 들어있는 텍스트를 찾는 것
 */
public class Ex12_PrintWriter_String_Finder {
    String baseDir = "D:\\Temp"; // 검색할 디렉토리
    String word = "hello"; // 검색할 단어
    String savetxt = "D:\\Temp\\result.txt"; // hello단어가 들어있는 파일 정보를 저장함

    void find() throws IOException { // 예외처리가 강제되고 있음
        File dir = new File(baseDir);
        if (!dir.isDirectory()) {
            System.out.println("유효한 폴더가 아니에요");
            System.exit(0);
        }
        PrintWriter writer = new PrintWriter(new FileWriter(savetxt)); // 없으면 자동 생성
        BufferedReader br = null;

        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile()) continue;

            br = new BufferedReader(new FileReader(files[i]));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    writer.write("word found in: " + files[i].getAbsolutePath() + "\n");
                }
            }
            br.close(); // 파일 읽은 후 닫기
        }
        writer.close(); // 모든 파일 처리 후 닫기
    }
    public static void main(String[] args) {
        Ex12_PrintWriter_String_Finder word_Find = new Ex12_PrintWriter_String_Finder();
        try {
            word_Find.find();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
