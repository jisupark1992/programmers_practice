package org.codingtest.graph;

import java.util.ArrayList;

public class 깊이_우선_탐색_순회 {

    /*  깊이 우선 탐색으로 모든 그래프의 노드를 순회하는 함수 solution()을 작성하세요. 시작 노드는 start로 주어집니다. graph는 [출발 노드, 도착노드]
    *   쌍들이 들어 있는 리스트입니다. 반환값은 그래프의 시작 노드부터 모든 노드를 깊이 우선 탐색으로 진행한 순서대로 노드가 저장된 리스트입니다.
    *
    *   - 제약 조건
    *   1. 노드의 최대 개수는 100개를 넘지 않습니다.
    *   2. 시작 노드부터 시작해서 모든 노드를 방문할 수 있는 경로가 항상 있습니다.
    *   3. 그래프의 노드는 문자열입니다.
    *
    *   - 시간 복잡도 분석
    *   노드의 개수를 N, 간선의 개수를 E라고 하면 인접 리스트를 생성할 때는 간선 개수만큼 연산하므로 시간 복잡도는 O(E)가 되고, 탐색 시 모든
    *   노드를 1회 방문하므로 N번 방문합니다. 따라서 깊이 우선 탐색의 시간 복잡도는 O(N + E)입니다.
    */

    // 인접 리스트 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    // 3. DFS 탐색 매서드
    private static void dfs(int now) {
        visited[now] = true; // 4. 현재 노드를 방문했음을 저장
        answer.add(now); // 5. 현재 노드를 결과 리스트에 추가
        // 6. 현재 노드와 인접한 노드 순회
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        // 1. 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. 그래프를 인접 리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // DFS를 순회한 결과를 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start); // 7. 시작 노드에서 깊이 우선 탐색 시작

        // 8. DFS 탐색 결과 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}