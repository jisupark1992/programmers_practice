package org.codingtest.array;

public class 행렬의_곱셈 {

    /*  2차원 행렬 arr1과 arr2를 입력받아 arr1에 arr2를 곱한 결과를 반환하는 solution() 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
    *   2. 행렬 arr1, arr2의 데이터는 -10 이상 20 이하인 자연수입니다.
    *   3. 곱할 수 있는 배열만 주어집니다.
    */

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 행렬 arr1와 arr2의 행과 열의 수
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 2. 결과를 저장할 2차원 배열 초기화
        int[][] answer = new int[r1][c2];

        // 3. 첫 번째 행렬 arr1의 각 행과 두 번째 행렬 arr2의 각 열에 대해
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                // 4. 두 행렬의 데이터를 곱해 결과 리스트에 더함
                for(int k = 0; k < c1; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}