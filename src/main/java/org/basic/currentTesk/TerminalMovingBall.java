package org.basic.currentTesk;

/**
 * 터미널(프롬프트)에서 ANSI 이스케이프 코드로 간단한 애니메이션을 보여주는 예제.
 * - 공이 좌에서 우로 천천히 이동하는 애니메이션.
 * - Windows 10+ 의 최신 PowerShell, Windows Terminal, VS Code 터미널, macOS/Linux 터미널에서 잘 동작합니다.
 * - 종료: Ctrl+C
 */
public class TerminalMovingBall {
    // ANSI escape sequences
    private static final String CSI = "\u001B[";       // Control Sequence Introducer
    private static final String HIDE_CURSOR = CSI + "?25l";
    private static final String SHOW_CURSOR = CSI + "?25h";
    private static final String CLEAR = CSI + "2J";      // clear entire screen
    private static final String HOME = CSI + "H";        // move cursor to home (1,1)

    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // 강제 종료 시 커서 복구
            System.out.print(SHOW_CURSOR);
        }));

        // 초기화
        System.out.print(HIDE_CURSOR + CLEAR + HOME);

        int posX = 1;        // 시작 위치 (좌측)
        int groundY = 10;    // 공이 위치할 라인

        try {
            while (true) {
                // 화면 지우기
                System.out.print(CLEAR + HOME);

                // 땅 라인
                for (int i = 0; i < 80; i++) {
                    System.out.print("_");
                }
                System.out.println();

                // 공 그리기
                drawBall(posX, groundY);

                // 이동
                posX += 1; // 오른쪽으로 이동 (1칸씩)
                if (posX > 70) posX = 1;

                Thread.sleep(500); // 느리게 움직이도록 (0.5초)
            }
        } finally {
            System.out.print(SHOW_CURSOR);
            System.out.flush();
        }
    }

    private static void drawBall(int x, int groundY) {
        // 위에 빈줄 5개
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
        // x 위치에 공 출력
        for (int i = 1; i < x; i++) {
            System.out.print(" ");
        }
        System.out.println("o");
    }

}
