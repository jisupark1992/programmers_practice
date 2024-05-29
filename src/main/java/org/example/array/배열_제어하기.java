package org.example.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class 배열_제어하기 {

    /*  정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution() 함수를 구현하세요.
     *
     *   - 제약 조건
     *   1. 정수 배열의 길이는 2 이상 1,000 이하입니다.
     *   2. 정수 배열의 각 데이터 값은 -100,000이상 100,000입니다.
     */

    // 중요!! : 자바에는 코딩 테스트에 유용한 표준 API들이 많고, 굳이 직접 작성하려 하지 마라

    // distinct 시간 복잡도 O(N) 보장
    public static int[] solution(int[] org) {
        int[] clone = org.clone();
        // 중복값 제거
        Integer[] result = Arrays.stream(clone).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder()); // 내림차순 정렬
        // int형 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    // distinct() 사용안하고 TreeSet 사용 시간 복잡도 O(NlogN)
    public static int[] treeSet(int[] org) throws NullPointerException {
        int[] clone = org.clone();
        // 중복 값 제거, 내림차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : clone) {
            set.add(num);
        }

        // int형 배열에 담아서 반환
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }
}
