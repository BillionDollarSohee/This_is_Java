package org.basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Cinema {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input;

    String[][] seat = new String[4][5];
    String[][] ReservationArr = new String[4][5];
    String ReservationSeat = "";
    String ReservationNumber = "";

    public Cinema() {
        seatClear(seat);
    }

    public void start() throws IOException {
        System.out.println("**********************");
        System.out.println("*****영화 예매 시스템*****");
        System.out.println("**********************");
        System.out.println("1. 예매하기");
        System.out.println();
        System.out.println("2. 예매 조회");
        System.out.println();
        System.out.println("3. 좌석 조희");
        System.out.println();
        System.out.println("4. 예매 취소");
        System.out.println();
        System.out.println("5. 시스템 종료");
        System.out.println();

        businessLogic();
    }

    public void businessLogic() throws IOException {
        // 입력 받기
        int input = Integer.parseInt(br.readLine());

        switch (input) {
            case 1:
                reservationPrint();
                String select = br.readLine();
                start();
                break;
            case 2:
                reservation();
                start();
                break;
            case 3:
                seatView();
                start();
                break;
            case 4:
                cancel();
                start();
                break;
            case 5:
                System.out.println("상영이 종료되었습니다. 감사합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("1 ~ 5 사이의 번호를 입력해 주세요.");
                start();
                break;
        }
    }

    public void reservationPrint() throws IOException {
        System.out.println("*********좌석 현황**********");
        seatView();

        System.out.println("좌석을 선택해주세요. 예)1-1");
        System.out.println("이미 예약된 좌석은 \"예매\"라고 표시됩니다.");

        String inputSeat = br.readLine();

        if (!inputSeat.matches("\\d+-\\d+")) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        String[] parts = inputSeat.split("-");
        int row = Integer.parseInt(parts[0]) - 1;
        int col = Integer.parseInt(parts[1]) - 1;

        if ("예매".equals(seat[row][col])) {
            System.out.println("이미 예약된 좌석입니다.");
            return;
        }

        System.out.println("예매 가능합니다. 예매하시겠습니까?");
        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");

        int input = Integer.parseInt(br.readLine());

        if (input == 1) {
            // 랜덤 예매번호 생성
            Random r = new Random();
            String ran = Integer.toString(r.nextInt(8) + 1);

            for (int i = 0; i < 7; i++) {
                ran += Integer.toString(r.nextInt(9));
            }

            // 좌석 예약 처리
            seat[row][col] = "예매";

            // 클래스 변수에 저장
            ReservationSeat = inputSeat;
            ReservationNumber = ran;
            ReservationArr[row][col] = ran;

            System.out.println("예매가 완료되었습니다.");
            System.out.println("예매한 좌석번호: " + ReservationSeat + " 예매번호: " + ReservationNumber);
            System.out.println("감사합니다.");
            start();
        } else if (input == 2 || input == 0) {
            start();
        } else {
            System.out.println("잘못된 입력입니다.");
        }


    }

    // 예매 조회
    public void reservation() throws IOException {
        System.out.println("예매번호를 입력해주세요.");
        String input = br.readLine();  // 사용자가 입력한 예약번호
        boolean real = false;
        String foundSeat = "";  // 조회용 좌석번호

        // 2차원 배열 순회
        for (int i = 0; i < ReservationArr.length; i++) {
            for (int j = 0; j < ReservationArr[i].length; j++) {
                if (input.equals(ReservationArr[i][j])) {
                    real = true;
                    foundSeat = (i + 1) + "-" + (j + 1);  // 좌석번호 계산
                    break;  // 찾으면 반복 종료
                }
            }
            if (real) break;
        }

        if (real) {
            System.out.println("고객님이 예매하신 좌석은 " + foundSeat +
                    " 예매번호는 " + input + "입니다.");
            start();
        } else {
            System.out.println("예약 내역이 없습니다.");
        }
    }

    public void cancel() throws IOException {
        System.out.println("예매번호를 입력해주세요.");
        String input = br.readLine();  // 사용자가 입력한 예약번호
        boolean real = false;
        int foundRow = -1, foundCol = -1;

        // 예약번호 배열 순회
        for (int i = 0; i < ReservationArr.length; i++) {
            for (int j = 0; j < ReservationArr[i].length; j++) {
                if (input.equals(ReservationArr[i][j])) {
                    real = true;
                    foundRow = i;
                    foundCol = j;
                    break;
                }
            }
            if (real) break;
        }

        if (real) {
            String seatNum = (foundRow + 1) + "-" + (foundCol + 1);
            System.out.println("고객님이 예약하신 좌석은 [" + seatNum + "]입니다.");
            System.out.println("취소하시겠습니까? 1: 예, 2: 아니오");

            int confirm = Integer.parseInt(br.readLine());
            if (confirm == 1) {
                // 좌석과 예약번호 초기화
                seat[foundRow][foundCol] = seatNum;       // 좌석 원래 상태로
                ReservationArr[foundRow][foundCol] = null; // 예약번호 삭제
                System.out.println("예매가 취소되었습니다. 감사합니다.");
            } else {
                System.out.println("취소가 취소되었습니다. 초기 화면으로 돌아갑니다.");
            }
        } else {
            System.out.println("예약 내역이 없습니다.");
        }
        start();
    }

    // 좌석 초기화
    private void seatClear(String[][] seat) {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j] = (i + 1) + "-" + (j + 1);
            }
        }
    }

    // 좌석 현황
    private void seatView() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if ("예매".equals(seat[i][j])) {
                    System.out.print("[예매]");
                } else {
                    System.out.print("[" + seat[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

    // 시스템 종료
    private void CinemaClose() {
        seatClear(seat);
        System.out.println("상영이 종료되었습니다. 감사합니다.");
    }
}
