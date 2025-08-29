package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

//        String str = "";
//        String[] str1 = {"a","d","f"};
//
//        for (String s : str1) {
//            System.out.println(s);
//        }
//
//        String name = "home.jpg";
//        int pointIndex = 0;
//
//        if (name.indexOf(".") != -1) {
//           pointIndex = name.indexOf(".");
//        }
//
//        System.out.println("file name is : " + name.substring(0,pointIndex) + " opener : " + name.substring(pointIndex+1, name.length()));
//
//        String str3 = "ASFHDHGDSDDAAA";
//        String result3 = str3.replace("DD","ddd");
//        System.out.println(result3);
//        System.out.println(str3.charAt(2));
//        System.out.println(str3.endsWith("DAAA"));
//
//        String str4 = "superMan, yellow, hahaha, hahaha";
//        String[] arr4 = str4.split(", ");
//        for (String a : arr4) {
//            System.out.println(a);
//        }
//
//
//        String str5 = "superMan. yellow. hahaha. hahaha";
//        String[] arr5 = str4.split("\\. ");
//
//        for (String a : arr5) {
//            System.out.println(a);
//        }
//
//        int sum = 0;
//        String[] numarr = {"1","2","3","4"};
//        for (int i = 0; i < numarr.length; i++) {
//            sum += Integer.parseInt(numarr[i]);
//        }
//        System.out.println(sum);
//
//        String jin = "123455-3325543";
//        String[] jinarr = jin.split("");
//        int jinSum = 0;
//        for (int i = 0; i < jinarr.length; i++) {
//            if (! jinarr[i].equals("-")) {
//                jinSum += Integer.parseInt(jinarr[i]);
//            }
//        }
//        System.out.println(jinSum);

        Scanner sc = new Scanner(System.in);
        String jumin;

        do {
            System.out.print("please Input (Ex: 990101-1234567): ");
            jumin = sc.nextLine();

            if (!Ex07_String_Total_Quzi.juminDisplay(jumin)) {
                System.out.println("Not Jumin.");
                continue;
            }

            if (!Ex07_String_Total_Quzi.Validator(jumin)) {
                System.out.println("Noy first number is 1~4.");
                continue;
            }

            // 올바른 주민번호라면 성별 출력
            Ex07_String_Total_Quzi.gender(jumin);
            break;

        } while (true);

        sc.close();


    }
}


class Ex07_String_Total_Quzi {
    //주민번호 14자리인지 확인 t/f 최대한 짧게
    // 뒷번호 1~4만 허옹 t/f
    // 1,3, 남자 2,4, 여자

//    static boolean juminDisplay(String jumin) {
//        Pattern pattern = Pattern.compile("\\d{6}-\\d{7}");
//        Matcher matcher = pattern.matcher(jumin);
//        return matcher.matches();
//    }

    static boolean juminDisplay(String jumin) {
        return jumin.matches("\\d{6}-\\d{7}");
    }

    static boolean Validator(String jumin) {
        char firstNum = jumin.charAt(7);
        return firstNum == '1' || firstNum == '2' || firstNum == '3' || firstNum == '4';
    }

    static void gender(String jumin) {
        char firstNum = jumin.charAt(7); // 뒷자리 첫 숫자
        if (firstNum == '1' || firstNum == '3') {
            System.out.println("man");
        } else if (firstNum == '2' || firstNum == '4') {
            System.out.println("woman");
        }
    }
}
