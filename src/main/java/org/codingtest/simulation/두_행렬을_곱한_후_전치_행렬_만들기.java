package org.codingtest.simulation;

public class 두_행렬을_곱한_후_전치_행렬_만들기 {

    /*  matrix1과 matrix2는 정수값으로 이루어진 3 x 3 행렬입니다. 이 두 행렬을 곱한 결과의 전치 행렬을 반환하는 solution 함수를 구현해주세요.
    *
    *   - 제약 조건
    *   1. matrix1, matrix2는 각각 3 x 3 크기의 정수 행렬입니다.
    *
     *   - 시간 복잡도 분석
    *   배열의 크기가 3 x 3으로 정해져 잇습니다. multiplyMatrices() 메서드는 삼중 반복문을 사용하므로 시간 복잡도는 O(27)이고,
    *   transposeMatrix 메서드는 이중 반복문을 사용하므로 시간 복잡도는 O(9)입니다. 모두 상수네요. 최종 시간 복잡도는 O(1)입니다.
    */

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        // 1. 결과 행렬을 0으로 초기화
        int[][] result = new int[3][3];
        // 2. 행렬 곱셈을 수행
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] + matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        // 3. 결과 행렬을 0으로 초기화
        int[][] result = new int[3][3];

        // 전치 행렬을 계산
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] solution(int [][] matrix1, int[][] matrix2) {
        // 주어진 두 행렬을 곱함
        int[][] multiplied = multiplyMatrices(matrix1, matrix2);

        // 곱셈 결과의 전치 행렬을 계산
        int[][] transposed = transposeMatrix(multiplied);
        return transposed;
    }
}