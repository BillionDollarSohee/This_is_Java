package org.example.io;

import java.io.File;

public class Ex08_File_Dir {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java 파일명 [디렉토리명]");
            System.exit(0); // 강제종료
        }

        File f = new File(args[0]);
        if (!f.exists() || !f.isDirectory()) {
            System.out.println("존재하지 않거나 디렉토리가 아닙니다.");
            System.exit(0);
        }

        // 실제 존재하고 디렉토리라면 안의 모든 자원을 꺼내는데 모두 파일객체로 보겠다.
        File[] files = f.listFiles();
        // [1.txt], [11.jpg], [new.txt], [참새]

        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName(); // 파일 or 폴더
            System.out.println(files[i].isDirectory() ? "[DIR] " + name : name);
        }
    }
}

/*
PS D:\MSA_2025\SOHEE\Practice\This_is_Java> javac src\main\java\org\example\io\Ex08_File_Dir.java
PS D:\MSA_2025\SOHEE\Practice\This_is_Java> java -cp src\main\java org.example.io.Ex08_File_Dir D:
[DIR] .git
.gitignore
[DIR] .gradle
[DIR] .idea
[DIR] build
build.gradle
[DIR] gradle
gradlew
gradlew.bat
[DIR] Note
[DIR] out
README.md
settings.gradle
[DIR] src
 */
