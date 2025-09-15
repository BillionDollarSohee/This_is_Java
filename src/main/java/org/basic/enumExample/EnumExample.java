package org.basic.enumExample;

/*
원래는 static final 인 상수들의 집합을 정의할 때 사용하는 특별한 타입으로
요일, 계절, 상태값(ON/OFF), 색상표 처럼 미리 정해진 값의 집합을 표현할 때 많이 사용

static final 상수보다 가독성이 좋고, 타입 안정성을 보장한다.
 */


// 요일을 표현하는 열거형
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        // 출력
        System.out.println("오늘은 " + today);

        // switch문과 함께 활용
        switch (today) {
            case MONDAY:
                System.out.println("한 주의 시작입니다!");
                break;
            case FRIDAY:
                System.out.println("불금이에요!");
                break;
            case SUNDAY:
                System.out.println("휴일이네요~");
                break;
            default:
                System.out.println("평범한 날입니다.");
        }
    }
}
