package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2,1,3,4,7,1};
        long start = 0;
        long end = 0;

        System.out.println("-------------------배열 5_4_1 정렬 Start-------------------");
        // 직접 구현한 버블 정렬 실행
        start = System.currentTimeMillis();
        int[] bubble = Array5_4_1.bubbleSort(arr);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 100 + " seconds ," + Arrays.toString(bubble));

        // Array 객체 내 sort 메소드 실행 내부에서 도는 알고리즘은 Dual-Pivot QuickSort 혹은 Tim-Sort
        start = System.currentTimeMillis();
        int[] sort = Array5_4_1.solution(arr);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 100 + " seconds ," + Arrays.toString(sort));

        // 정렬 후 두 배열 값이 같은지 확인
        System.out.println(Arrays.equals(bubble, sort));
        System.out.println("-------------------배열 5_4_1 정렬 End-------------------");

        System.out.println("-------------------배열 5_4_2 중복 제거 정렬 Start------------------");
        // treeSet 실행 시간 복잡도 O(NlogN)
        start = System.currentTimeMillis();
        int[] treeSet = Array5_4_2.treeSet(arr);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 100 + " seconds ," + Arrays.toString(treeSet));

        // Array 객체 내 sort 메소드 실행 내부에서 도는 알고리즘은 Dual-Pivot QuickSort 혹은 Tim-Sort
        start = System.currentTimeMillis();
        int[] useDistinct = Array5_4_2.solution(arr);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 100 + " seconds ," + Arrays.toString(useDistinct));

        // 정렬 후 두 배열 값이 같은지 확인
        System.out.println(Arrays.equals(treeSet, useDistinct));
        System.out.println("-------------------배열 5_4_2 중복 제거 정렬 End------------------");

        System.out.println("-------------------배열 5_5_3 두 개 뽑아서 더하기 Start------------------");
        int[] numbers = Array5_5_3.solution(arr);
        System.out.println(Arrays.toString(numbers));
        System.out.println("-------------------배열 5_5_3 두 개 뽑아서 더하기 End------------------");

    }
}