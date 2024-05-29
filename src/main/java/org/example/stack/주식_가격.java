package org.example.stack;

import java.util.Stack;

public class 주식_가격 {

    /*  초 단위로 기록된 주식 가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 반환하도록
    *   solution() 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    *   2. prices의 길이는 2이상 100,000 이하입니다.
    *
    *   - 시간 복잡도 분석
    *   N은 prices의 길이입니다. 최악의 경우 각 prices의 원소들은 한 번씩 푸시/팝하므로 시간 복잡도는 O(N)입니다.
    */
    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; // 1. 가격이 떨어지지 않은 기간을 저장할 배열

        // 스택을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>(); // 2. 스택 생성
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 3. 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // 4. 스택에 남아 있는 가격들은 가격이 떨어지지 않는 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}