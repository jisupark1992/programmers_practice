package org.example;

import java.util.Arrays;

public class Array5_4_1 {

    /*  정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요
    *
    *   - 제약 조건
    *   1. 정수 배열의 길이는 2 이상 10^5 이하입니다.
    *   2. 정수 배열의 각 데이터 값은 -100,000이상 100,000입니다.
    */
    public static void main(String[] args) {
        int[] arr = new int[100000];

        // 직접 구현한 버블 정렬 실행
        long start = System.currentTimeMillis();
        int[] bubble = bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + " seconds");

        // Array 객체 내 sort 메소드 실행 내부에서 도는 알고리즘은 Dual-Pivot QuickSort 혹은 Tim-Sort
        start = System.currentTimeMillis();
        int[] sort = solution(arr);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + " seconds");

        // 정렬 후 두 배열 값이 같은지 확인
        System.out.println(Arrays.equals(bubble, sort));
    }

    // sort 사용
    private static int[] solution(int[] org) {
        int[] clone = org.clone();
        Arrays.sort(clone);
        return clone;
    }

    // sort 사용 안하고 버블 정렬을 구현 했을 때
    private static int[] bubbleSort(int[] org) {
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