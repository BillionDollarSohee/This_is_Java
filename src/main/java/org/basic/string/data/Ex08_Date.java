package org.basic.string.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
이제는 사용하지 않는다.
숫자와 (쉼표) 날짜는 예쁘게 포맷팅 해야한다.
SimpleDateFormat를 검색해서 만들면 String이 된다
다시 되돌릴때 일정한 규칙이 있어야 가능하다.
 */

public class Ex08_Date {

    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);

        ///////////////////////////////////////////////////

        String exDate1 = "2021/01/01";
        String exDate2 = "20210101";

        System.out.println(checkDate(exDate1));
        System.out.println(checkDate(exDate2));


        //날짜의 차이 구하기
        //Date.getTime()은
        //Date를 밀리세컨드로 변환해서 long형 숫자 데이터로 반환합니다.
        //이를 이용하면 산술 연산으로 시간 차이를 쉽게 구할 수 있습니다.

        Calendar cal = Calendar.getInstance(); //나라별 차이 때문에
        System.out.println(cal.getTime());

        String date1 = "2021/01/02"; //날짜1
        String date2 = "2021/01/01"; //날짜2

        Date format1 = new SimpleDateFormat("yyyy/MM/dd").parse(date1);
        Date format2 = new SimpleDateFormat("yyyy/MM/dd").parse(date2);
        System.out.println(format1);
        System.out.println(format2);

        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24*60*60); //일자수 차이

        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");
    }
    public static boolean checkDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy/MM/dd"); //검증할 날짜 포맷 설정
            dateFormatParser.setLenient(false); //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
            dateFormatParser.parse(checkDate); //대상 값 포맷에 적용되는지 확인
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}