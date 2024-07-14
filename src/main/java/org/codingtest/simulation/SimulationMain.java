package org.codingtest.simulation;

import java.util.Arrays;

public class SimulationMain {
    public static void main(String[] args) {
        System.out.println("--------------------시뮬레이션 14_2_59 배열 회전하기 Start--------------------");
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = 1;
        System.out.println("결과 : " + Arrays.deepToString(배열_회전하기.solution(arr, n)));
        System.out.println("--------------------시뮬레이션 14_2_59 배열 회전하기 End----------------------");
        System.out.println("--------------------시뮬레이션 14_2_60 두 행렬을 곱한 후 전치 행렬 만들기 Start--------------------");
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        System.out.println("결과 : " + Arrays.deepToString(두_행렬을_곱한_후_전치_행렬_만들기.solution(matrix1, matrix2)));
        System.out.println("--------------------시뮬레이션 14_2_60 두 행렬을 곱한 후 전치 행렬 만들기 End----------------------");
        System.out.println("--------------------시뮬레이션 14_2_61 달팽이 수열 만들기 Start--------------------");
        n = 3;
        System.out.println("결과 : " + Arrays.deepToString(달팽이_수열_만들기.solution(n)));
        System.out.println("--------------------시뮬레이션 14_2_61 달팽이 수열 만들기 End----------------------");
    }
}