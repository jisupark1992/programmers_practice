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
        System.out.println("--------------------정렬 13_3_52 문자열 내 마음대로 정렬하기 Start--------------------");
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println("결과 : " + Arrays.toString(문자열_내_마음대로_정렬하기.solution(strings, n)));
        System.out.println("--------------------정렬 13_3_52 문자열 내 마음대로 정렬하기 End----------------------");
        System.out.println("--------------------정렬 13_3_53 정수 내림차순으로 배치하기 Start--------------------");
        n = 118372;
        System.out.println("결과 : " + 정수_내림차순으로_배치하기.solution(n));
        System.out.println("--------------------정렬 13_3_53 정수 내림차순으로 배치하기 End----------------------");
        System.out.println("--------------------정렬 13_4_54 K번째 수 Start--------------------");
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println("결과 : " + Arrays.toString(K번째_수.solution(array, commands)));
        System.out.println("--------------------정렬 13_4_54 K번째 수 End----------------------");
        System.out.println("--------------------정렬 13_4_55 가장 큰 수 Start--------------------");
        int numbers[] = {6, 10, 2};
        System.out.println("결과 : " + 가장_큰_수.solution(numbers));
        System.out.println("--------------------정렬 13_4_55 가장 큰 수 End----------------------");
        System.out.println("--------------------정렬 13_4_56 튜플 Start--------------------");
        s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println("결과 : " + Arrays.toString(튜플.solution(s)));
        System.out.println("--------------------정렬 13_4_56 튜플 End----------------------");
        System.out.println("--------------------정렬 13_4_57 지형 이동 Start--------------------");
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height = 3;
        System.out.println("결과 : " + 지형_이동.solution(land, height));
        System.out.println("--------------------정렬 13_4_57 지형 이동 End----------------------");
        System.out.println("--------------------정렬 13_4_58 전화번호 목록 Start--------------------");
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println("결과 : " + 전화번호_목록.solution(phone_book));
        System.out.println("--------------------정렬 13_4_58 전화번호 목록 End----------------------");
    }
}