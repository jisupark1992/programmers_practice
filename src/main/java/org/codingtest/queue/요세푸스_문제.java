package org.codingtest.queue;

import java.util.ArrayDeque;

public class 요세푸스_문제 {

    /*  N명의 사람이 원 형태로 서 있습니다. 각 사람은 1부터 N까지 번호표를 갖고 있습니다.
    *   그리고 임의의 숫자 K가 주어졌을 때 다음과 같이 사람을 없앱니다.
    *    * 1번 번호표를 가진 사람을 기준으로 K번째  사람을 없앱니다.
    *    * 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다.
    *   N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하는 solution() 함수를 구현해주세요.
    *
    *   - 제약 조건
    *   1. N과 K는 1이상 1000이하의 자연수입니다.
    *
    *   - 시간 복잡도 분석
    *   N은 전체 사람 수 K는 제거된 사람의 번호입니다. K - 1번 poll하고 1번 add하는 동작을 N번 반복하므로 쵲오 시간 복잡도는 O(N * K)입니다.
    */
    public static int solution(int N, int K) {
        // 1. 1부터 N까지의 번호를 deque에 추가
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        // 2. deque에 하나의 요소가 남을 때까지 반복
        while (deque.size() > 1) {
            // 3. K번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst(); // 4. K번째 요소 제거
        }

        return deque.pollFirst(); // 5. 마지막으로 남은 요소 반환
    }
}