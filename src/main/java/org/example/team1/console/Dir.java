package org.example.team1.console;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Dir {

    static String defaultPath = "D:" + File.separator;
    static String path = defaultPath;

    public static void main(String[] args) throws Exception { // 사용법 dir 두번 치면 됨

        path = "D:/MSA_2025";

        System.out.println("Microsoft Windows DOS 명령어 [Version 1.1]");
        System.out.println("2025  All rights reserved\n");
        System.out.println(path);
        Scanner sc = new Scanner(System.in);

        String[] input = null;
        System.out.print(path + ">");
        input = sc.nextLine().trim().split(" ");
        System.out.println(input[0].toLowerCase());

        while (true) {
            System.out.print(path + ">");
            String inputLine = sc.nextLine().trim();

            if (inputLine.equalsIgnoreCase("exit")) {
                System.out.println("프로그램 종료");
                break;
            }

            String[] s = inputLine.split(" ");
            String command = s[0].toLowerCase();

            switch (command) {
                case "dir":
                    searchDirectory(path);
                    break;
                case "md":
                case "mkdir":
                    System.out.println("폴더 생성 명령 (미구현)");
                    break;
                case "rd":
                case "rmdir":
                    System.out.println("폴더 삭제 명령 (미구현)");
                    break;
                case "ren":
                case "rename":
                    System.out.println("이름 변경 명령 (미구현)");
                    break;
                case "type":
                    System.out.println("파일 내용 출력 명령 (미구현)");
                    break;
                case "help":
                    System.out.println("지원 명령어: dir, cd, md, rd, ren, type, exit");
                    break;
                default:
                    System.out.println("알 수 없는 명령어: " + command);
            }
        }

        sc.close();
}

    // dir 디렉토리 내용을 상세하게 출력
    public static void searchDirectory(String path) {
        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("디렉토리가 존재하지 않거나 경로가 올바르지 않습니다: " + path);
            return;
        }

        // 헤더
        System.out.println("Mode     LastWriteTime         Length Name");
        System.out.println("----     -------------         ------ ----");

        // 파일/폴더 목록
        File[] files = dir.listFiles();
        if (files == null) return;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a h:mm");

        for (File f : files) {
            String mode = f.isDirectory() ? "d-----" : "-a----";
            String lastModified = sdf.format(f.lastModified());
            String length = f.isDirectory() ? "" : String.valueOf(f.length());
            String name = f.getName();

            System.out.printf("%-6s %15s %8s %s\n", mode, lastModified, length, name);
        }
    }
}