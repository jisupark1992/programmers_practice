package org.codingtest.dynamicprogramming;

import java.util.Arrays;

public class LIS길이_계산하기 {

    /*  정수 배열 nums에서 LIS의 길이를 찾는 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. nums는 최대 길이 1,000의 정수 배열입니다.
    *   2. nums의 각 요소는 -1,000 이상 1,000 이하의 정수입니다.
    *
    *   - 시간 복잡도 분석
    *   M과 N은 각각 문자열의 길이입니다. dp 배열의 크기는 M * N 이고 이를 초기화하는데 필요한 시간 복잡도는 O(M * N)입니다. 이후 반복문은
    *   M * N번 수행하므로 시간 복잡도는 O(M * N)입니다.
    */

    public static int solution(int[] nums) {
        int n = nums.length;
        // 1. dp[i]는 nums[i]를 마지막으로 하는 LIS의 길이를 저장하는 배열
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 2. nums[i]와 nums[j]를 비교하여, nums[i]가 더 큰 경우에만 처리
                if (nums[i] > nums[j]) {
                    // 3. nums[i]를 이용하여 만든 부분수열의 길이와 num[j]를 이용하여 만든 부분수열의 길이 + 1 중 최댓값을 저장
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 4. dp배열에서 최댓값을 찾아 최장 증가 부분 수열의 길이를 반환
        return Arrays.stream(dp).max().getAsInt();
    }
}