package org.codingtest.gptpick;

public class gptTwoDay {

    /*  GPT 코딩 테스트 준비 2일차
    *   - 문제 : 정렬된 배열 nums와 target이 주어졌을 때, target이 배열에 존재하면 인덱스를 반환하고, 존재하지 않으면 -1을 반환하는 함수를 작성하라. (이진 탐색을 사용해야 함)
    *   - 조건 : 시간 복잡도는 O(log n) 이어야 함.
    *           배열이 정렬되 있다는 점을 활용해야 함
    *   - 예제 입력 : int[] nums = {-1, 0, 3, 5, 9, 12}, int target = 9;
    *   - 예제 출력 : 4
    */
    public static int solution(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low <= high) {
            // Gpt 개선 피드백 : 큰 수를 다룰 때 오버플로우 위험이 있음
            // mid = (low + high) / 2;
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 오른쪽 탐색
                low = mid + 1;
            } else {
                // 왼쪽 탐색
                high = mid -1;
            }
        }

        return -1;
    }
}