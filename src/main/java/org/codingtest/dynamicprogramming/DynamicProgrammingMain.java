package org.codingtest.dynamicprogramming;

public class DynamicProgrammingMain {
    public static void main(String[] args) {
        System.out.println("--------------------동적 계획법 15_2_67 LCS 길이 계산하기 Start--------------------");
        String str1 = "ABCBDAB", str2 = "BDCAB";
        System.out.println("결과 : " + LCS길이_계산하기.solution(str1, str2));
        System.out.println("--------------------동적 계획법 15_2_67 LCS 길이 계산하기 End----------------------");
        System.out.println("--------------------동적 계획법 15_2_68 LIS 길이 계산하기 Start--------------------");
        int[] nums = {1, 4, 2, 3, 1, 5, 7, 3};
        System.out.println("결과 : " + LIS길이_계산하기.solution(nums));
        System.out.println("--------------------동적 계획법 15_2_68 LIS 길이 계산하기 End----------------------");
    }
}