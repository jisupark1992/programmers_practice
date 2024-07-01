package org.codingtest.backtracking;

import java.util.Arrays;

public class 스도쿠_퍼즐 {

    /*  9 x 9 스도쿠 보드를 다 채워 완성된 스도쿠 보드를 반환하는 solution() 함수를 작성하세요. 해는 유일하지 않을 수 있습니다. 스도쿠의
    *   조건에 맞다면 맞는 해라고 생각하시면 됩니다. 스도쿠의 규칙은 아래와 같습니다.
    *       1. 가로줄, 세로줄에는 1부터 9까지의 숫자가 한 번씩 나타나야 합니다.
    *       2. 9 x 9 보드를 채울 9개의 작은 박스(3 x 3 크기)에도 1부터 9까지의 숫자가 한 번씩 나타나야 합니다.
    *
    *   - 제약 조건
    *   1. 문제에 주어지는 board 중 스도쿠를 완성하지 못하는 board는 없다고 가정합니다. 예를 들어 특정 행이나 열에 같은 숫자가 있는 경우는 없습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 스도쿠에서 빈칸의 개수입니다. 빈칸당 1~9의 수가 들어가므로 최종 시간복잡도는 O(9^n)입니다. 다만 실제 연산은 유망 함수에 의해 훨씬 적습니다.
    */

    private static class Block {
        int i, j;
        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int[][] Borad;

    private static boolean isVaild(int num, int row, int col) {
        // 1. 현재 위치에 num이 들어갈 수 있는지 검사
        return !(inRow(num, row) || inCol(num, col) || isBox(num, row, col));
    }

    private static boolean inRow(int num, int row) {
        // 2. 해당 행에 num이 있는지 확인
        return Arrays.stream(Borad[row]).anyMatch(n -> n == num);
    }

    private static boolean inCol(int num, int col) {
        // 3. 해당 열에 num이 있는지 확인
        for (int i =0; i < 9; i++) {
            if (Borad[i][col] == num) {
                return true;
            }
        }

        return false;
    }

    private static boolean isBox(int num, int row, int col) {
        // 4. 현재 위치의 3 x 3 박스에 num이 있는지 확인
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (Borad[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    private static Block findEmptyPosition() {
        // 5. 스도쿠 보드에서 비어 있는 위치 반환
        for (int i =0 ; i < 9; i++) {
            for (int j =0 ; j < 9; j++) {
                if (Borad[i][j] == 0) {
                    return new Block(i, j);
                }
            }
        }

        return null;
    }

    private static boolean findSolution() {
        // 6. 비어 있는 위치에 가능한 숫자를 넣어가며 스도쿠 해결
        Block emptyPos = findEmptyPosition();
        // 7. 빈칸이 없으면 스도쿠가 해결된 것으로 간주
        if (emptyPos == null) {
            return true;
        }

        int row = emptyPos.i;
        int col = emptyPos.j;

        for (int num = 1; num <= 9; num++) {
            if (isVaild(num, row, col)) {
                Borad[row][col] = num;
                // 8. 다음 빈칸을 채워 탐색
                if (findSolution()) {
                    return true;
                }
                // 9. 가능한 숫자가 없으면 원래의 0으로 되돌림
                Borad[row][col] = 0;
            }
        }

        return false;
    }

    public static int[][] solution(int[][] borad) {
        Borad = borad;
        findSolution();
        return borad;
    }
}