package org.codingtest.backtracking;

import java.util.ArrayList;
import java.util.Comparator;

public class 사라지는_발판 {

    /*
    *   사라지는 발판
    *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/92345
    *
    *   - 시간 복잡도 분석
    *   board의 가로 길이를 N, 세로 길이를 M이라고 하면 각 위치에서 상하좌우 4개의 경우의 수가 있으므로 최종 시간 복잡도는 O(4^(M*N))입니다.
    */

    // 백트래킹을 위한 재귀 메서드의 반환값을 저장함
    private static class Result {
        boolean win;
        int step;

        public Result(boolean win, int step) {
            this.win = win;
            this.step = step;
        }
    }

    // 1. 게임판의 행과 열의 개수를 저장합니다.
    private static int ROW, COL;

    // 2. 이동할 수 있는 방향을 저장합니다. 좌, 하, 우, 상 순서로 저장되어 있습니다.
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {-1, 0, 1, 0};
    private static boolean[][] visited;
    private static int[][] Board;

    // 3. 주어진 위치가 유효한 위치인지 확인하는 메서드입니다.
    private static boolean isVaildPos(int r, int c) {
        return 0 <= r && r < ROW && 0 <= c && c < COL;
    }

    // 4. 재귀적으로 호출되는 메서드입니다.
    private static Result recursive(int[] alpha, int[] beta, int step) {
        // 5. 현재 플레이어의 위치와 이동 가능한지 여부,
        // 상대 플레이어가 이긴 경우를 저장하는 변수들입니다.
        int[] now = step % 2 == 0 ? alpha : beta;
        boolean canMove = false;
        boolean isOpponentWinner = true;

        // 6. 이긴 경우와 지는 경우를 저장하는 리스트입니다.
        ArrayList<Integer> winSteps = new ArrayList<>();
        ArrayList<Integer> loseSteps = new ArrayList<>();

        // 7. 현재 위치에서 이동할 수 있는 모든 방향으로 이동합니다.
        for (int i = 0; i < 4; i++) {
            int nr = now[0] + DR[i];
            int nc = now[1] + DC[i];
            // 8. 이동할 수 있는 위치인 경우
            if (isVaildPos(nr, nc) && !visited[nr][nc] && Board[nr][nc] == 1) {
                canMove = true;
                // 9. 두 플레이어의 위치가 같으면 A 플레이어가 이긴 것이므로 true와 step + 1을 반환합니다.
                if (alpha[0] == beta[0] && alpha[1] == beta[1]) {
                    return new Result(true, step + 1);
                }

                // 10. 재귀적으로 호출하여 이긴 여부와 남은 턴 수를 가져옵니다.
                visited[now[0]][now[1]] = true;
                Result result = step % 2 == 0 ? recursive(new int[]{nr, nc}, beta, step + 1) : recursive(alpha, new int[]{nr, nc}, step + 1);
                visited[now[0]][now[1]] = false;

                // 11. 상대 플레이어가 이긴 경우만 true로 유지합니다.
                isOpponentWinner &= result.win;
                // 12. 이긴 경우와 지는 경우를 저장합니다.
                if (result.win) {
                    winSteps.add(result.step);
                } else {
                    loseSteps.add(result.step);
                }
            }
        }

        // 13. 이동할 수 있는 위치가 없는 경우
        if (!canMove) {
            return new Result(false, step);
        }
        // 14. 상대 플레이어가 이긴 경우
        if (isOpponentWinner) {
            return new Result(false, winSteps.stream().max(Comparator.comparingInt(o -> o)).get());
        }
        // 15. 현재 플레이어가 이긴 경우
        return new Result(true, loseSteps.stream().min(Comparator.comparingInt(o -> o)).get());
    }

    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        Board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        // 16. A 플레이어가 이길 때까지 걸리는 최소 턴 수를 반환합니다.
        return recursive(aloc, bloc, 0).step;
    }
}