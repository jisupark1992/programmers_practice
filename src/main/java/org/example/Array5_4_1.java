package org.example;

import java.util.Arrays;

public class Array5_4_1 {

    /*  정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요
    *
    *   - 제약 조건
    *   1. 정수 배열의 길이는 2 이상 10^5 이하입니다.
    *   2. 정수 배열의 각 데이터 값은 -100,000이상 100,000입니다.
    */

    // sort 사용
    public static int[] solution(int[] org) {
        int[] clone = org.clone();
        Arrays.sort(clone);
        return clone;
    }

    // sort 사용 안하고 버블 정렬을 구현 했을 때
    public static int[] bubbleSort(int[] org) {
        int[] arr = org.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}