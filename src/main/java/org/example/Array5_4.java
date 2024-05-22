package org.example;

import java.util.Arrays;

public class Array5_4 {


    /*  정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요
    *
    *   - 제약 조건
    *   1. 정수 배열의 길이는 2 이상 10^5 이하입니다.
    *   2. 정수 배열의 각 데이터 값은 -100,000이상 100,000입니다.
    */
    public static void main(String[] args) {
        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);

        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }
}