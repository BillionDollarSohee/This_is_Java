package org.example.basics;

public interface Operation {
    public static void main(String[] args) {

        // 해당 월의 일수
        int month = 3; //월을 데이터 제공
        String res = ""; //빈문자열로 초기화
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                res = "31일";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                res = "30일";
                break;
            case 2:
                res = "29일";
                break;
            default:
                res = "월 데이터가 아닙니다";
        }
        System.out.println(month + " 월 은 " + res + " 까지 입니다");


        // 학번 구하기
        int score=87;
        String grade=""; //문자열 초기화 // A+ , A- , C+
        System.out.println("당신의 점수는 : " + score);
        //논리구문
        if(score >= 90) {
            grade="A";

			/*
			if(score >= 95) {
				grade+="+";
			}else {
				grade+="-";
			}
			*/
            grade = (score >= 95) ? (grade+="+") : (grade+="-");

        }else if(score >= 80) {
            grade="B";
            grade = (score >= 85) ? (grade+="+") : (grade+="-");
        }else if(score >= 70) {
            grade="C";
            grade = (score >= 75) ? (grade+="+") : (grade+="-");
        }else {

            grade="F";
        }
        System.out.println("당신의 학점은 : " + grade);


        //구구단
        for(int i = 2 ; i <= 9 ; i++) {

            for(int j = 1 ; j <= 9 ; j++) {
                //System.out.print(i+"*"+ j+"="+i*j+"\t");
                System.out.printf("%d*%d=%d\t",i,j,i*j);
            }
            System.out.println(); //엔터
        }

    }
}
