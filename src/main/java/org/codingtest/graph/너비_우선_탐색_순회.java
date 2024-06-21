package org.codingtest.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 너비_우선_탐색_순회 {

    /*  너비 우선 탐색으로 모든 노드를 순회하는 함수 solution()을 작성하세요. 시작 노드는 매개변수 start로 주어집니다. graph는 (출발 노드, 도착 노드)
    *   쌍들이 들어 있는 리스트입니다. 반환값은 그래프의 시작 노드부터 모든 노드를 너비 우선 탐색으로 진행한 순서대로 노드가 저장된 리스트입니다.
    *
    *   - 제약 조건
    *   1. 노드의 최대 개수는 100개를 넘지 않습니다.
    *   2. 시작 노드부터 시작해서 모든 노드를 방문할 수 있는 경로가 항상 있습니다.
    *   3. 그래프의 노드는 숫자입니다.
    *
    *   - 시간 복잡도 분석
    *   노드의 개수를 N, 간선의 개수를 E라고 하면 인접 리스트를 생성할 때는 간선 개수만큼 연산하므로 시간 복잡도는 O(E)가 되고, 탐색 시 모든
    *   노드를 1회 방문하므로 N번 방문합니다. 따라서 너비 우선 탐색의 시간 복잡도는 O(N + E)입니다.
    */

    // 인접 리스트 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    // BFS 탐색 매서드
    private static void bfs(int start) {
        // 2. 탐색시 맨 처음 방문할 노드를 add 하고 방문 처리
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        // 3. 큐가 비어 있지 않은 동안 반복
        while (!queue.isEmpty()) {
            // 4. 큐에 있는 원소 중 가장 먼저 추가된 원소를 poll하고 정답 리스트에 추가
            int now = queue.poll();
            answer.add(now);
            // 5. 인접한 이웃 노드들에 대해서
            for (int next : adjList[now]) {
                if (!visited[next]) { // 6. 방문하지 않은 인접한 노드인 경우
                    // 7. 인접한 노드를 방문 처리함
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n - 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // 1. 방문 여부를 저장할 배열
        visited = new boolean[n - 1];
        answer = new ArrayList<>();
        bfs(start); // 8. 시작 노드에서 너비 우선 탐색 시작

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}