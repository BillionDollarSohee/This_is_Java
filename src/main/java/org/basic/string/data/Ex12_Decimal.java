package org.basic.string.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class Ex12_Decimal {

    public static void main(String[] args) {
        BigDecimal binnumber = new BigDecimal("10000.12345");


        BigDecimal binnumber1 = new BigDecimal("10000.12345");
        BigDecimal binnumber2 = new BigDecimal("10000");

        System.out.println("덧셈 : " + binnumber1.add(binnumber2));
        System.out.println("뺄셈 : " + binnumber1.subtract(binnumber2));
        System.out.println("곱셈 : " + binnumber1.multiply(binnumber2));
        System.out.println("나눗셈 : " + binnumber1.divide(binnumber2));
        System.out.println("나머지 : " + binnumber1.remainder(binnumber2));


        BigDecimal bigDecimal = BigDecimal.valueOf(100000.12345); //double -> BigDecimal

        int int_bigNum = bigDecimal.intValue(); //BigDecimal -> int
        long long_bigNum = bigDecimal.longValue(); //BigDecimal -> long
        float float_bigNum = bigDecimal.floatValue(); //BigDecimal -> float
        double double_bigNum = bigDecimal.doubleValue(); //BigDecimal -> double
        String String_bigNum = bigDecimal.toString(); //BigDecimal -> String

        System.out.println("int_bigNum : " + int_bigNum);
        System.out.println("long_bigNum : " + long_bigNum);
        System.out.println("float_bigNum : " + float_bigNum);
        System.out.println("double_bigNum : " + double_bigNum);
        System.out.println("String_bigNum : " + String_bigNum);


        //BigIntger 두 수 비교
        BigInteger bigNumber1 = new BigInteger("100000");
        BigInteger bigNumber2 = new BigInteger("1000000");

        //두 수 비교 compareTo 맞으면 0   틀리면 -1
        int compare = bigNumber1.compareTo(bigNumber2);
        System.out.println(compare);


        //자바에서 금액 콤마 처리하기
        int amount = 1000000000;
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(amount);
        System.out.println(money);

        //정규식 표현하기
        String amount2 = "1000000000";
        String amount3 = amount2.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        System.out.println(amount3);
    }

}
