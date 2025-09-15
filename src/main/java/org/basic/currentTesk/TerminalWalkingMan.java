package org.basic.currentTesk;

/**
 * 터미널(프롬프트)에서 ANSI 이스케이프 코드로 간단한 애니메이션을 보여주는 예제.
 * - 사람이 좌에서 우로 걸어가는 것처럼 보이게 구현.
 * - 세로로 머리-몸통-다리가 출력되도록 수정.
 * - Windows 10+ 의 최신 PowerShell, Windows Terminal, VS Code 터미널, macOS/Linux 터미널에서 잘 동작합니다.
 * - 종료: Ctrl+C
 */
public class TerminalWalkingMan {
    // ANSI escape sequences
    private static final String CSI = "\u001B[";       // Control Sequence Introducer
    private static final String HIDE_CURSOR = CSI + "?25l";
    private static final String SHOW_CURSOR = CSI + "?25h";
    private static final String CLEAR = CSI + "2J";      // clear entire screen
    private static final String HOME = CSI + "H";        // move cursor to home (1,1)

    // 사람 프레임 (ASCII 아트, 걷는 동작)
    // 사람 프레임 (ASCII 아트, 걷는 동작)
    private static final String[][] FRAMES = {
            {
                    "  O  ",
                    "  |  ",
                    " / \\"
            },
            {
                    "  O  ",
                    "  |  ",
                    "   /\\"
            },
            {
                    "  O  ",
                    "  |  ",
                    "  / \\"
            },
            {
                    "  O  ",
                    "  |  ",
                    " /\\  "
            }
    };


    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // 강제 종료 시 커서 복구
            System.out.print(SHOW_CURSOR);
        }));

        // 초기화
        System.out.print(HIDE_CURSOR + CLEAR + HOME);

        int posX = 5;          // 시작 위치 (좌측)
        int groundY = 15;      // 땅 높이 기준 라인
        int frame = 0;

        try {
            while (true) {
                // 화면 지우기
                System.out.print(CLEAR + HOME);

                // 땅 라인 그리기
                System.out.println();
                for (int i = 0; i < 80; i++) {
                    System.out.print("_");
                }
                System.out.println();

                // 사람 그리기 (좌표 기반)
                drawMan(posX, groundY, FRAMES[frame]);

                // 프레임 업데이트
                frame = (frame + 1) % FRAMES.length;
                posX += 2; // 오른쪽으로 이동 (2칸씩)

                if (posX > 70) posX = 5;

                Thread.sleep(700); // 느리게 움직이도록 (0.7초)
            }
        } finally {
            System.out.print(SHOW_CURSOR);
            System.out.flush();
        }
    }

    private static void drawMan(int x, int groundY, String[] sprite) {
        // sprite[0] = 머리, sprite[1] = 몸통, sprite[2] = 다리
        for (int i = 0; i < sprite.length; i++) {
            int row = groundY - (sprite.length - 1 - i);
            System.out.print(CSI + row + ";" + x + "H" + sprite[i]);
        }
        System.out.flush();
    }
}
