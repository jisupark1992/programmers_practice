package org.codingtest.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class BacktrackingMain {
    public static void main(String[] args) {
        System.out.println("--------------------백트래킹 12_2_43 1부터 N까지 숫자 중 합이 10이 되는 조합 구하기 Start--------------------");
        System.out.println("결과 : " + Arrays.deepToString(new ArrayList[]{백트레킹_몸풀기_문제.solution(5)}));
        System.out.println("--------------------백트래킹 12_2_43 1부터 N까지 숫자 중 합이 10이 되는 조합 구하기 End----------------------");
        System.out.println("--------------------백트래킹 12_2_44 스도쿠 퍼즐 Start--------------------");
        int[][] board =
                {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        System.out.println("결과 : " + Arrays.deepToString(스도쿠_퍼즐.solution(board)));
        System.out.println("--------------------백트래킹 12_2_44 스도쿠 퍼즐 End----------------------");
        System.out.println("--------------------백트래킹 12_3_45 피로도 Start--------------------");
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println("결과 : " + 피로도.solution(k, dungeons));
        System.out.println("--------------------백트래킹 12_3_45 피로도 End----------------------");
        System.out.println("--------------------백트래킹 12_3_46 N-퀸 Start--------------------");
        int n = 4;
        System.out.println("결과 : " + N_퀸.solution(n));
        System.out.println("--------------------백트래킹 12_3_46 N-퀸 End----------------------");
    }
}