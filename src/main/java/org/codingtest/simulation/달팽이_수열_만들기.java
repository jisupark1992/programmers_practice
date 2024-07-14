package org.codingtest.simulation;

public class 달팽이_수열_만들기 {

    /*  n을 입력받아 n x n 크기의 2차원 배열을 생성하여 달팽이 수열일 채우는 solution 함수를 구현하세요. 달팽이 수열은 숫자 1부터
    *   시작하여 시계 방향 나선형으로 채우는 수열을 말합니다.
    *
    *   - 제약 조건
    *   1. n은 2이상 10미만의 자연수입니다.
    *   2. 숫자는 배열의 첫 번째 행, 첫 번째 열에서 시작합니다.
    *
    *   - 시간 복잡도 분석
    *   N은 입력받은 배열의 행 혹은 열 크기입니다. 배열은 N * N 구성이므로 달팽이 수열을 순회할 때 필요한 시간 복잡도는 O(N^2)입니다.
    */

    public static int[][] solution(int n) {
        // 1. n 크기의 2차원 배열 생성
        int[][] snailArray = new int[n][n];
        int num = 1; // 2. 달팽이 수열의 시작 숫자

        // 3. 행과 열의 시작과 끝 인덱스를 설정
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // 4. 첫 번째 행 채우기
            for (int i = startCol; i <= endCol; i++) {
                snailArray[startRow][i] = num++;
            }
            startRow++;

            // 5. 마지막 열 채우기
            for (int i = startRow; i <= endRow; i++) {
                snailArray[i][endCol] = num++;
            }
            endCol--;

            // 6. 마지막 행 채우기
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    snailArray[endRow][i] = num++;
                }
                endRow--;
            }

            // 7. 첫 번째 열 채우기
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    snailArray[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return snailArray;
    }
}