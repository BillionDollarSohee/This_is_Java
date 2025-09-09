package org.example.team1.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DosApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DosApp app = new DosApp();
        while (true) {
            System.out.println("명령어 입력 : [명령어] {경로}");
            System.out.print(System.getProperty("user.dir") + ">");
            String[] commands = sc.nextLine().split(" ");
            switch (commands[0].toUpperCase()) {
                case "DIR":
                    if (!commands[1].equals("")) {
                        app.searchDirectory(commands[1]);
                    } else {
                        System.out.println("경로를 제대로 입력해주세요.");
                    }
                    break;
                case "MD":
                case "MKDIR":
                    if (!commands[1].equals("")) {
                        app.mkdir(commands[1]);
                    } else {
                        System.out.println("경로를 제대로 입력해주세요.");
                    }
                    break;
                case "RD":
                case "RMDIR":
                    if (!commands[1].equals("")) {
                        app.removeDirectory(commands[1]);
                    } else {
                        System.out.println("경로를 제대로 입력해주세요.");
                    }
                    break;
                case "TYPE":
                    if (!commands[1].equals("")) {
                        app.textContext(commands[1]);
                    } else {
                        System.out.println("경로를 제대로 입력해주세요.");
                    }
                    break;
                case "EXIT":
                    app.exitSystem();
                    break;
                default:
                    System.out.println("명령어 오류입니다. 명령어는 DIR, MD or MKDIR, RD or RMDIR, EXIT 가 있습니다.");
            }

        }
    }
    void textContext(String path) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = "";
            for(int i =0; (line = br.readLine()) !=null ; i++) {
                System.out.println(line);
            }
        }catch(Exception e) {
            try {
                br.close();
                fr.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }
    void searchDirectory(String path) {
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
    void removeDirectory(String path) {
        //path가 있다면

        File folder = new File(path);

        try {
            if (folder.exists()) {
                File[] folderList = folder.listFiles();

                for (int i = 0; i < folderList.length; i++) {
                    if (folderList[i].isFile()) {
                        folderList[i].delete();
                    } else {
                        removeDirectory(folderList[i].getPath());
                    }
                    folderList[i].delete();
                }
                folder.delete();
                System.out.println("디렉토리를 삭제 완료");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    void exitSystem() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
    void mkdir(String folderName){
        File dir = new File(folderName);
        if(dir.isDirectory()){
            System.out.println("동일한 이름의 폴더가 이미 있습니다.");
        } else {
            dir.mkdirs();
        }
    }

}

