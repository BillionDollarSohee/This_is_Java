package org.example.ETC;

public class Ex07_String_Total_Quzi {
    //주민번호 14자리인지 확인 t/f 최대한 짧게

    // 뒷번호 1~4만 허옹 t/f
    // 1,3, 남자 2,4, 여자



    static boolean juminDisplay(String jumin) {
        return jumin.matches("\\d{6}-\\d{7}");
    }

    static boolean Validator(String jumin) {
        char firstNum = jumin.charAt(7);
        return firstNum == '1' || firstNum == '2' || firstNum == '3' || firstNum == '4';
    }

    static void gender(String jumin) {
        String firstNum = Integer.toString(jumin.indexOf(7));
        if (firstNum.equals("1") || firstNum.equals("3")){
            System.out.println("man");
        } else if (firstNum.equals("2") || firstNum.equals("4")) {
            System.out.println("woman");
        }
    }
}
