package org.example.array;

/*
배열은 객체다 (Array)
1. new 를 통해서 생성 (주소값)
2. heap 메모리 생성 (관리 된다)
3. 정적배열(고정배열) : 배열은 한번 선언하면(크기가 정해지면) 크기 변경 <> 동적배열 (Collection : API 클래스)
4. 자료구조(알고리즘) : 제어문 + 배열 >> 기초적인 자료구조
*/

/*
		 제어문을 통해서 max라는 변수에 시험점수중에서 가장 큰 최대값을 담고
		 min 변수에는 시험점수중에서 가장 작은 값을 담으세요
		 결과: max > 97
		 결과: min > 54

		 단) for문 한번만 사용해서 max 와 min 값을 (처음 하시는 분 for)
*/

public class Array {
    public static void main(String[] args) {
        // 국문과 학생들의 기말고사 시험점수
        int[] score = new int[] {79,88,97,54,56,95};
        int max = score[0]; //79
        int min = score[0]; //79

        for(int i=0; i<score.length; i++) {
            max = (max < score[i]) ? score[i] : max;
            min = Math.min(min, score[i]); // 줄여쓰기 가능
        }
        System.out.printf("max: %d min: %d \n",max, min); // 확인) max: 97 min: 54

        //2번
        int[] numbers = new int[10];
        //10개의 방의 값을 1~10까지로 초기화 시키고 출력하세요
        for (int j = 0; j < numbers.length; j++) {
            numbers[j]=j+1;
            System.out.print(numbers[j] + " ");
        }

        //어느 학생의 기말고사 시험점수 (5과목)
        int[] jumsu = {100,55,90,60,78};
        int sum=0;
        float avg = 0f;
        //1. 총과목의 수
        //2. 과목의 합
        //3. 과목의 평균
        //2.3번 하나의 for 문으로 해결
        for(int i = 0 ; i < jumsu.length ; i++) {
            sum+=jumsu[i];
            if(i == jumsu.length -1) { //마직막 방이라면
                avg = sum/(float)jumsu.length;
            }
        }
        System.out.printf("총 과목수:[%d] ,총점:[%d] ,평균:[%f]",jumsu.length,sum,avg);
    }
}
