package org.codingtest.backtracking;

import java.util.ArrayList;

public class 백트레킹_몸풀기_문제 {

    /*  1부터 N까지 숫자 중 합이 10이 되는 조합 구하기
    *   정수 N을 입력받아 1부터 N까지의 숫자 중에서 합이 10이 되는 조합을 리스트로 반환하는 solution 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. 백트레킹을 활용해야 합니다.
    *   2. 숫자 조합은 오름차순으로 정렬되어야 합니다.
    *   3. 같은 숫자는 한 번만 선택할 수 있습니다.
    *   4. N은 1 이상 10 이하인 정수입니다.
    *
    *   - 시간 복잡도 분석
    *   노드의 개수를 N, 간선의 개수를 E라고 하면 인접 리스트를 생성할 때는 간선 개수만큼 연산하므로 시간 복잡도는 O(E)가 되고, 탐색 시 모든
    *   노드를 1회 방문하므로 N번 방문합니다. 따라서 깊이 우선 탐색의 시간 복잡도는 O(N + E)입니다.
    */

    // 1. 조합 결과를 담을 리스트
    private static ArrayList<ArrayList<Integer>> result;
    private static int n;
    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
        // 2. 합이 10이 되면 결과 리스트에 추가
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        // 3. 다음에 선택할 수 있는 숫자들을 하나씩 선태갛면서
        for (int i = start; i <= n; i++) {
            // 4. 선택한 숫자의 합이 10보다 작거나 같으면
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                // 5. 백트래킹 메서드를 재귀적으로 호출합니다.
                backtrack(sum + i, list, i + 1);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        // 6. 백트래킹 메서드 호출
        backtrack(0, new ArrayList<>(), 1);
        return result;
    }
}