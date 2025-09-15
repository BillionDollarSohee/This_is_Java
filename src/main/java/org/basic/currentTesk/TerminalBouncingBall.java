package org.basic.currentTesk;

/**
 * 터미널(프롬프트)에서 ANSI 이스케이프 코드로 간단한 애니메이션을 보여주는 예제.
 * - 박스 안에서 공이 톡톡 튕깁니다.
 * - Windows 10+ 의 최신 PowerShell, Windows Terminal, VS Code 터미널, macOS/Linux 터미널에서 잘 동작합니다.
 * - 종료: Ctrl+C
 */
public class TerminalBouncingBall {
    // ANSI escape sequences
    private static final String CSI = "\u001B[";       // Control Sequence Introducer
    private static final String HIDE_CURSOR = CSI + "?25l";
    private static final String SHOW_CURSOR = CSI + "?25h";
    private static final String CLEAR = CSI + "2J";      // clear entire screen
    private static final String HOME = CSI + "H";        // move cursor to home (1,1)

    private static final int WIDTH = 60;   // 내부 그리드 폭 (테두리 제외)
    private static final int HEIGHT = 18;  // 내부 그리드 높이 (테두리 제외)

    // 색상 팔레트 (밝은 색 위주)
    private static final String[] COLORS = {
            CSI + "38;5;208m", // orange
            CSI + "38;5;45m",  // cyan
            CSI + "38;5;201m", // pink
            CSI + "38;5;190m", // yellow
            CSI + "38;5;87m",  // aqua
            CSI + "38;5;118m"  // green
    };
    private static final String RESET = CSI + "0m";

    public static void main(String[] args) throws Exception {
        // Windows CMD의 구형 콘솔은 ANSI가 비활성화되어 있을 수 있습니다.
        // 가능하면 Windows Terminal / PowerShell / VS Code 내장 터미널을 사용하세요.

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // 강제 종료 시 커서 복구
            System.out.print(RESET + SHOW_CURSOR);
        }));

        // 초기화
        System.out.print(HIDE_CURSOR + CLEAR + HOME);

        // 박스 테두리 미리 그리기
        drawBox();

        // 공의 초기 위치와 속도
        int x = 2;          // 1..WIDTH
        int y = 2;          // 1..HEIGHT
        int vx = 1;         // +-1
        int vy = 1;         // +-1
        int colorIdx = 0;

        long frameDelayMs = 33; // ~30 FPS
        long lastTime = System.nanoTime();
        double accumulator = 0.0;
        double dt = 1.0 / 1000000.0; // 물리 업데이트 간격(초) — 부드러운 반사 계산용

        try {
            while (true) {
                long now = System.nanoTime();
                double elapsed = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;
                accumulator += elapsed;

                // 고정 시간 스텝으로 위치 업데이트
                while (accumulator >= dt) {
                    // 다음 위치 예측
                    int nx = x + vx;
                    int ny = y + vy;

                    // 벽 충돌 검사 (1..WIDTH / 1..HEIGHT 범위)
                    if (nx < 1 || nx > WIDTH) {
                        vx *= -1;
                        colorIdx = (colorIdx + 1) % COLORS.length; // 튕길 때 색 바꾸기
                    } else {
                        x = nx;
                    }

                    if (ny < 1 || ny > HEIGHT) {
                        vy *= -1;
                        colorIdx = (colorIdx + 1) % COLORS.length;
                    } else {
                        y = ny;
                    }

                    accumulator -= dt;
                }

                // 프레임 그리기
                renderBall(x, y, COLORS[colorIdx]);

                // 간단한 HUD
                renderHud();

                Thread.sleep(frameDelayMs);
            }
        } finally {
            // 화면 정리
            System.out.print(RESET + SHOW_CURSOR + CSI + (HEIGHT + 4) + ";1H");
            System.out.flush();
        }
    }

    private static void drawBox() {
        StringBuilder sb = new StringBuilder();
        // 화면 최상단으로
        sb.append(HOME);

        // 상단 여백
        sb.append("  ").append("Bouncing Ball — ANSI Console Animation\n");

        // 상단 테두리
        sb.append("  +");
        for (int i = 0; i < WIDTH; i++) sb.append('-');
        sb.append("+\n");

        // 중간 (세로 테두리)
        for (int j = 0; j < HEIGHT; j++) {
            sb.append("  |");
            for (int i = 0; i < WIDTH; i++) sb.append(' ');
            sb.append("|\n");
        }

        // 하단 테두리
        sb.append("  +");
        for (int i = 0; i < WIDTH; i++) sb.append('-');
        sb.append("+\n");

        System.out.print(sb);
        System.out.flush();
    }

    private static void renderBall(int x, int y, String color) {
        // 공의 실제 화면 좌표 계산
        // 좌측 상단 (박스 내부 1,1)은 터미널의 (row=3, col=3) 지점부터라고 가정
        int row = 3 + (y - 1);
        int col = 3 + (x - 1);

        // 이전 프레임 잔상 지우기용 전체 내부만 지우지 않고, 해당 위치만 그리기 위해
        // 더블버퍼 대신 공 위치만 갱신: 배경을 공백으로 한번 쓰고 다시 공을 그리면 깜빡임이 커지므로
        // 여기서는 공 위치에 바로 공만 새로 그립니다. (단순 구현)

        // 화면 갱신: 해당 좌표로 커서 이동 후 문자 출력
        System.out.print(CSI + row + ";" + col + "H" + color + "●" + RESET);
        System.out.flush();
    }

    private static void renderHud() {
        // 안내 문구 (박스 아래)
        String msg1 = "Ctrl+C 로 종료 | 색상은 벽에 튕길 때 변경";
        System.out.print(CSI + (HEIGHT + 4) + ";1H" + "  " + msg1 + repeat(' ', Math.max(0, WIDTH - msg1.length())));
        System.out.flush();
    }

    private static String repeat(char c, int n) {
        StringBuilder sb = new StringBuilder(Math.max(0, n));
        for (int i = 0; i < n; i++) sb.append(c);
        return sb.toString();
    }
}
