package org.example.team1.lotto;

public class Lotto {

	private int[] randNums; //로또 번호
	private int index;
	private int temp;
	
	public Lotto(){
		randNums = new int[6];
	}

    // 번호 출력
    public void printRandNum() {
    	
        System.out.printf("[ ");
        for(int randNum : randNums) {
            System.out.printf("%d ",randNum);
        }
        System.out.println("]");
    }

    // 랜덤 번호 최대 45번 까지 추출
    public int[] pickSixRandomNumbers() {
        for (int i = 0; i < randNums.length; i++) {
            index = i;
            temp = 0;
            do {
            	temp = (int) (Math.random() * 45) + 1;
            }while(validDupNum(this.randNums, index , temp));
            randNums[i]=temp;
        }
        return randNums;
    }

    // 번호 정렬
	public int[] bubbleSort(int[] arr) {
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
        return arr;
    }
	
	// 번호 확인
	boolean validDupNum(int[] numbers, int index ,int randNum){
		//배열로 새로들어올 숫자를 기존배열에서 중복되는지 확인후 중복되면 true 종복안되면 false 로 반환
		for(int i=0; i<index;i++){
			if(numbers[i] == randNum){
				System.out.println("중복값 추출 중복된 값 randNum = " + numbers[i]);
					return true;
				}
		}
		return false;
	}
	public void promotionDrawing(){
		int[] luckyNumber = {3,7,10};
		int bonusNum;
		do {
			bonusNum = (int) (Math.random() * 45) + 1;
        }while(validDupNum(luckyNumber ,3, bonusNum));
		
		System.out.println("\n보너스 추첨 진행");
		System.out.println(" 3 : 로봇청소기 \n 7 : 황금 5돈 \n 10 : 최신식 스마트 TV \n  보너스 넘버 " + bonusNum + " : 1억");
		// 3 7 10 보너스넘버 포함
		
		for(int num : randNums){
			if(luckyNumber[0] == num){
				System.out.println("로청 상품 당첨!");
			}else if(luckyNumber[1] == num){
				 	System.out.println("황금 5돈 상품 당첨");
			}else if(luckyNumber[2] == num) {
					System.out.print("최신식 스마트 TV 상품 당첨");
			}else if(bonusNum == num){
				// 보너스넘버는 3 7 10 제외 => lucky넘버 배열 받아서 진행
					System.out.println("1억 상품 당첨");
			}
		}
	}
}
