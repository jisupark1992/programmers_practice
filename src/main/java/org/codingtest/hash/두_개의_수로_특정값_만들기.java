package org.codingtest.hash;

import java.util.HashSet;

public class 두_개의_수로_특정값_만들기 {

    /*  n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을 때 이 중에서 합이 target인 두 수가 arr에 있는지 찾고, 있으면 true
    *   없으면 false를 반환하는 solution() 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. n은 2이상 10,000 이하의 자연수입니다.
    *   2. arr의 각 원소는 1 이상 10,000 이하의 자연수입니다.
    *   3. arr의 원소 중 중복되는 원소는 없습니다.
    *   4. target은 1 이상 20,000 이하의 자연수입니다.
    *
    */
    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            // 1. target에서 현재 원소를 뺀 값이 해시셋 있는지 확인
            if (hashSet.contains(target - i)) {
                return true;
            }
            // 2. 해시셋 현재 값 저장
            hashSet.add(i);
        }

        return false;
    }
}