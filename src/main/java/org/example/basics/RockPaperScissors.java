package org.example.basics;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double random = Math.random();

        int computerChoice = (int)(3 * random + 1);

        boolean exit = true;

        System.out.printf("이길 때까지 하는 가위, 바위, 보 게임을 시작합니다. 가위(1) 바위(2) 보(3) 1,2,3 중 하나를 선택해주세요 \n");

        while(exit) {

            System.out.printf("입력하세요: ");

            int playerChoice = Integer.parseInt(sc.nextLine());

            System.out.println("컴퓨터: " + computerChoice);

            if (computerChoice == playerChoice) {

                System.out.println("무승부입니다");

            } else if ((computerChoice == 1 && playerChoice == 3) || (computerChoice == 2 && playerChoice == 1) || (computerChoice == 3 && playerChoice == 2)) {

                System.out.println("컴퓨터한테 졌습니다");

            } else {

                System.out.println("당신이 이겼습니다. 게임을 종료합니다.");

                exit = false;

            }
        }
    }
}
