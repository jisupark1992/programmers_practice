package org.codingtest.sort;

public class 정렬이_완료된_두_배열_합치기 {

    /*  이미 정렬이 완료되어 있는 두 배열 arr1, arr2을 받아 병합 정렬하는 solution() 함수를 구현하세요.
    *
    *   - 제약 조건
    *   1. arr1과 arr2는 각각 길이가 1이상 100,000 이하입니다.
    *   2. arr1과 arr2는 각각 오름차순으로 정렬되어 있습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 arr1의 길이, M은 arr2의 길이입니다. 이 배열들을 합치면서 모든 원소를 한 번씩 순회하므로 최종 시간 복잡도는 O(N + M)입니다.
    */

    public static int[] solution(int[] arr1, int[] arr2) {
        // 정렬된 배열을 저장할 배열 생성
        int[] merged = new int[arr1.length + arr2.length];
        int k = 0, i = 0, j = 0; // 3개 배열의 인덱스 초기화

        // 두 배열을 순회하면서 정렬된 배열을 생성
        while (i < arr1.length && j < arr2.length) {
            merged[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }

        // arr1 이나 arr2 중 남아 있는 원소들을 정렬된 배열 뒤에 추가
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }
}