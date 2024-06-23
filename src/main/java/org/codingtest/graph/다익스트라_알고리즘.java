package org.codingtest.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라_알고리즘 {

    /*  주어진 그래프와 시작 노드를 이용하여 다익스트라 알고리즘을 구현하는 solution() 함수를 작성하세요. 인수는 graph, start 총 2개입니다.
    *   graph는 배열로 주어지며 노드의 연결 정보와 가중치가 저장되어 있습니다. 예를 들어 [[1, 3, 2], [2, 3, 4]]이면 1번 노드에서 3번 노드는
    *   가중치 2로 연결되어 있고, 2번 노드에서 3번 노드 0은 가중치 4로 연결되어 있는 것입니다. start는 정수형으로 주어지며 출발 노드를 의미합니다.
    *   n은 정수형으로 주어지며 노드의 개수입니다. 반환값은 시작 노드부터 시작 노드를 포함한 모든 노드까지의 최단 거리를 순서대로 저장한 배열입니다.
    *
    *   - 제약 조건
    *   1. 그래프의 노드 개수는 최대 10,000개입니다.
    *   2. 각 노드는 0 이상의 10,000 이하 정수로 표현합니다.
    *   3. 모든 가중치는 0 이상의 정수이며 10,000을 넘지 않습니다.
    *
    *   - 시간 복잡도 분석
    *   노드의 개수를 N, 간선의 개수를 E라고 하겠습니다. dist 배열을 초기화할 떄의 시간 복잡도는 O(N)입니다. 반복문을 보면 현재 노드의
    *   
    */

    // 노드의 정보(노드 번호와 거리)를 쌍으로 저장할 클래스 생성
    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        // 1. 인접 리스트를 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. graph 정보를 인접 리스트로 저장
        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        // 3. 모든 노드의 거리 값을 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 4. 시작 노드의 거리 값은 0으로 초기화
        dist[start] = 0;

        // 5. 우선순위 큐를 생성하고 시작 노드를 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 6. 현재 가장 거리가 짧은 노드를 가져옴
            Node now = pq.poll();

            // 7. 만약 현재 노드의 거리 값이 큐에서 가져온 거리 값보다 크면, 해당 노드는 이미 방문한 것이므로 무시
            if (dist[now.dest] < now.cost) {
                continue;
            }

            // 8. 현재 노드와 인접한 노드들의 거리 값을 계산하여 업데이트
            for (Node next : adjList[now.dest]) {
                // 9. 기존에 발견했던 거리보다 더 짧은 거리를 발견하면 거리 값을 갱신하고 큐에 넣음
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost = next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        // 10. 최단 거리를 담고 있는 배열을 반환
        return dist;
    }
}