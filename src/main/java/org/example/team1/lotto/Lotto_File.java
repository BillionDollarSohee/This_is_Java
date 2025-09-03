package org.example.team1.lotto;

public class Lotto_File {
    private int[] randNums; // 로또 번호

    public Lotto_File(){
        randNums = new int[6];
    }

    // 번호 출력 + 문자열 반환
    public String printRandNum() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int randNum : randNums) {
            sb.append(randNum).append(" ");
        }
        sb.append("]");

        System.out.println(sb.toString()); // 콘솔 출력
        return sb.toString();               // 파일 저장용
    }

    // 1 ~ 45 범위의 랜덤 번호 추출
    public int[] pickFiveRandomNumbers() {
        for (int i = 0; i < randNums.length; i++) {
            int temp;
            do {
                temp = (int) (Math.random() * 45) + 1;
            } while (validDupNum(randNums, i, temp));
            randNums[i] = temp;
        }
        return randNums;
    }

    // 번호 정렬
    public void bubbleSort(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    // 중복 체크
    private boolean validDupNum(int[] numbers, int index, int randNum){
        for(int i = 0; i < index; i++){
            if(numbers[i] == randNum){
                return true;
            }
        }
        return false;
    }

    // 보너스 추첨 및 결과 문자열 반환
    public String promotionDrawing() {
        int[] luckyNumber = {3, 7, 10};
        int bonusNum;
        do {
            bonusNum = (int) (Math.random() * 45) + 1;
        } while (validDupNum(luckyNumber, 3, bonusNum));

        StringBuilder sb = new StringBuilder();
        sb.append("\n보너스 추첨 진행\n");
        sb.append(" 3 : 로봇청소기 \n 7 : 황금 5돈 \n 10 : 최신식 스마트 TV \n 보너스 넘버 ")
                .append(bonusNum).append(" : 1억\n");

        for (int num : randNums) {
            if (luckyNumber[0] == num) {
                sb.append("로청 상품 당첨!\n");
            } else if (luckyNumber[1] == num) {
                sb.append("황금 5돈 상품 당첨\n");
            } else if (luckyNumber[2] == num) {
                sb.append("최신식 스마트 TV 상품 당첨\n");
            } else if (bonusNum == num) {
                sb.append("1억 상품 당첨\n");
            }
        }

        System.out.println(sb.toString()); // 콘솔 출력
        return sb.toString();               // 파일 저장용
    }
}
