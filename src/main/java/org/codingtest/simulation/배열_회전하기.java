package org.codingtest.simulation;

public class 배열_회전하기 {

    /*  2차원 배열 arr을 시계 방향으로 90도 * n번 회전하는 solution 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. 회전 횟수 n은 자연수이며 1 ~ 4입니다.
    *   2. 2차원 배열의 행과 열의 크기는 같고, 행의 크기는 10을 넘지 않습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 배열의 한 변의 길이입니다. 배열을 탐색하는데에 필요한 시간 복잡도는 O(N^2)이고, 최대 4번 회전하는 연산은 상수이므로 무시할
    *   수 있습니다. 따라서 최종 시간 복잡도는 O(N^2)입니다.
    */

    // 1. 2차원 배열을 인자로 받고, 90도 회전시키는 메서드
    private static int[][] rotate90(int[][] arr) {
        // 2. 배열의 크기 저장
        int n = arr.length;
        // 3. 배열의 크기와 동일한2차원 배열 생성(초깃값은 0)
        int[][] rotateArr = new int[n][n];

        // 4. 배열을 90도 회전
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateArr[j][n - i - 1] = arr[i][j];
            }
        }

        // 5. 90도로 회전한 배열 반환
        return rotateArr;
    }

    public static int[][] solution(int [][] arr, int n) {
        // 6. 90도로 회전 메서드 호출
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }
}