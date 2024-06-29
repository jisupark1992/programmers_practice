package org.codingtest.graph;

import java.util.ArrayList;

public class 전력망을_둘로_나누기 {

    /*
    *   n개의 송접탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다. 당신은 이 전선 중 하나를 끊어서 현재의 전력망 네트워크를 2개로
    *   분할하려고 합니다. 이때 두 전력망이 갖는 송전탑의 개수를 최대한 비슷하게 맞추려 합니다. 송전탑 개수 n, 전선 정보 wires가 매개변수로
    *   주어집니다. 이때 송전탑 개수가 비슷하도록 전선 중 하나를 끊어서 두 전력망으로 나누고, 두 전력망이 가지고 있는 송전탑 개수 차이를 반환하는
    *   solution 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. n은 2 이상 100 이하인 자연수입니다.
    *   2. wires는 길이가 n - 1인 정수형 2차원 배열입니다.
    *       * wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어
    *         있다는 것을 의미합니다.
    *       * 1 <= v1 < v2 <= n입니다.
    *       * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
    *
    *   - 시간 복잡도 분석
    *   보드의 한 변의 길이를 N이라고 하면 너비 우선 탐색은 N * N개의 노드를 탐색하고 네 방향을 고려하므로 시간 복잡도는 O(N^2)입니다.
    */

    private static boolean[] visited;
    private static ArrayList<Integer>[] adList;
    private static int N, answer;

    public static int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;

        // 1. 전선의 연결 정보를 저장할 인접 리스트 초기화
        adList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adList[i] = new ArrayList<>();
        }

        // 2. 전선의 연결 정보를 인접 리스트에 저장
        for (int[] wire : wires) {
            adList[wire[0]].add(wire[1]);
            adList[wire[1]].add(wire[0]);
        }

        visited = new boolean[n + 1];
        // 3. 길이 우선 탐색 시작
        dfs(1);
        return answer;
    }

    private static int dfs(int now) {
        visited[now] = true;

        // 4. 자식 노드의 수를 저장하고 반환할 변수 선언
        int sum = 0;
        // 5. 연결된 모든 전선을 확인
        for (int next : adList[now]) {
            if (!visited[next]) {
                // 6. (전체 노드 - 자식 트르이 노드 수) - (자식 트르이 노드 수) 의 절댓값이 가장 작은 값을 구함
                int cnt = dfs(next); // 자식 트리가 가진 노드의 수
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                // 7. 자식 노드의 수를 더함
                sum += cnt;
            }
        }

        // 8. 전체 자식 노드의 수에 1(현재 now 노드)을 더해서 반환
        return sum + 1;
    }
}