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

        System.out.println("-------------------배열 5_5_4 수포자들의 찍기 순위 Start------------------");
        int[] answers = {1, 3, 2, 4, 2};
        int[] rank = Array5_5_4.solution(answers);
        System.out.println(Arrays.toString(rank));
        System.out.println("-------------------배열 5_5_4 수포자들의 찍기 순위 End------------------");

        System.out.println("-------------------배열 5_5_5 행렬의 곱셈 Start------------------");
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] mulArr = Array5_5_5.solution(arr1, arr2);
        System.out.println(Arrays.deepToString(mulArr));
        System.out.println("-------------------배열 5_5_5 행렬의 곱셈 End------------------");

        System.out.println("-------------------배열 5_5_6 실패율 Start------------------");
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] fails = Array5_5_6.solution(5, stages);
        System.out.println(Arrays.toString(fails));
        System.out.println("-------------------배열 5_5_6 실패율 End------------------");

    }
}