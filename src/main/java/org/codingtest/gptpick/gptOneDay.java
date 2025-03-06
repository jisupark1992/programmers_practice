package org.codingtest.gptpick;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class gptOneDay {

    /*  GPT 코딩 테스트 준비 1일차
    *   - 문제 : 배열에서 두 숫자의 합이 특정 목표값이 되는 인덱스를 찾는 문제
    *   - 입력 예시 : num = [2, 7, 11, 15], target = 8
    *   - 출력 예시 : [0, 1] (2 + 7 = 9이므로 인덱스 0과 1 리턴)
    *   - 제약 사항 : 같은 요소를 두 번 사용할 수 없음
    */

    public static Integer[] solution2(int[] nums, int target) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 본인 인덱스 제외한 숫자 루핑
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (target == nums[i] + nums[j]) {
                        result.add(i);
                        result.add(j);
                    }
                }
            }
        }

        return result.toArray(new Integer[0]);
    }

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // 해시맵에 보관된 값이 존재하면 결과 반환
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // 현재 값과 인덱스를 해시맵에 저장
            map.put(nums[i], i);
        }

        return new int[]{}; // 정답이 없을 경우 빈 배열 반환
    }
}