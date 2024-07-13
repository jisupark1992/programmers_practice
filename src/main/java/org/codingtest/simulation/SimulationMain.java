package org.codingtest.simulation;

import java.util.Arrays;

public class SimulationMain {
    public static void main(String[] args) {
        System.out.println("--------------------시뮬레이션 14_2_59 배열 회전하기 Start--------------------");
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = 1;
        System.out.println("결과 : " + Arrays.deepToString(배열_회전하기.solution(arr, n)));
        System.out.println("--------------------시뮬레이션 14_2_59 배열 회전하기 End----------------------");
    }
}