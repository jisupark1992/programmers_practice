package org.codingtest.sort;

import java.util.Arrays;

public class SortMain {
    public static void main(String[] args) {
        System.out.println("--------------------정렬 13_2_50 계수 정렬 구현하기 Start--------------------");
        String s = "hello";
        System.out.println("결과 : " + 계수_정렬_구현하기.solution(s));
        System.out.println("--------------------정렬 13_2_50 계수 정렬 구현하기 End----------------------");
        System.out.println("--------------------정렬 13_2_51 정렬이 완료된 두 배열 합치기 Start--------------------");
        int[] arr1 = {1, 3, 5}, arr2 = {2, 4, 6};
        System.out.println("결과 : " + Arrays.toString(정렬이_완료된_두_배열_합치기.solution(arr1, arr2)));
        System.out.println("--------------------정렬 13_2_51 정렬이 완료된 두 배열 합치기 End----------------------");

    }
}