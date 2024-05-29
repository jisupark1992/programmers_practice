package org.codingtest.stack;

import java.util.Arrays;

public class StackMain {
    public static void main(String[] args) {
        System.out.println("--------------------스택 6_3_8 올바른 괄호 Start--------------------");
        String s = "(()())()";
        System.out.println("입력 값 : " + s + ", 결과 : " + 올바른_괄호.solution(s));
        s = ")()(";
        System.out.println("입력 값 : " + s + ", 결과 : " + 올바른_괄호.solution(s));
        System.out.println("--------------------스택 6_3_8 올바른 괄호 End--------------------");
        System.out.println("--------------------스택 6_3_9 10진수를 2진수로 변환하기 Start--------------------");
        int decimal = 123456789;
        System.out.println("입력 값 : " + decimal + ", 결과 : " + 진수_변환하기.solution(decimal));
        System.out.println("--------------------스택 6_3_9 10진수를 2진수로 변환하기 End--------------------");
        System.out.println("--------------------스택 6_4_10 괄호 회전하기 Start--------------------");
        s = "[](){}";
        System.out.println("입력 값 : " + s + ", 결과 : " + 괄호_회전하기.solution(s));
        s = "}]()[{";
        System.out.println("입력 값 : " + s + ", 결과 : " + 괄호_회전하기.solution(s));
        System.out.println("--------------------스택 6_4_10 괄호 회전하기 End--------------------");
        System.out.println("--------------------스택 6_4_11 짝지어 제거하기 Start--------------------");
        s = "baabaa";
        System.out.println("입력 값 : " + s + ", 결과 : " + 짝지어_제거하기.solution(s));
        System.out.println("--------------------스택 6_4_11 짝지어 제거하기 End--------------------");
        System.out.println("--------------------스택 6_4_12 주식 가격 Start--------------------");
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println("결과 : " + Arrays.toString(주식_가격.solution(prices)));
        System.out.println("--------------------스택 6_4_12 주식 가격 End--------------------");
        System.out.println("--------------------스택 6_4_13 크레인 인형 뽑기 게임 Start--------------------");
        int[][] board = {{0, 0, 0, 0}, {0, 0, 1, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println("결과 : " + 크레인_인형_뽑기_게임.solution(board, moves));
        System.out.println("--------------------스택 6_4_13 크레인 인형 뽑기 게임 End--------------------");
        System.out.println("--------------------스택 6_4_14 표 편집 Start--------------------");
        int n = 8, k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println("결과 : " + 표_편집.solution(n, k, cmd));
        System.out.println("--------------------스택 6_4_14 표 편집 End--------------------");
    }
}