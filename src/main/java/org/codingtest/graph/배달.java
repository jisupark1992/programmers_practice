package org.codingtest.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {

    /*
    *   배달
    *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/12978
    *
    *   - 제약 조건
    *   1. 마을의 개수 N은 1 이상 50 이하의 자연수입니다.
    *   2. road의 길이는 1 이상 2,000 이하입니다.
    *   3. road의 각 원소는 마을을 연결하는 각 도로의 정보를 나타냅니다.
    *   4. road는 길이가 3인 배열이며 순서대로 (a, b, c)를 나타냅니다.
    *       * a, b(1 <= a, b <= N, a != b)는 도로가 연결하는 두 마을의 번호이며 c(1 <= c <= 10,000, c는 자연수)는 도로를 지나는 데 걸리는 시간입니다.
    *       * 두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다.
    *       * 한 도로의 정보가 여러 번 중복해서 주어지지 않습니다.
    *   5. K는 음식 배달이 가능한 시간을 나타내며 1 이상 500,000 이하입니다.
    *   6. 임의의 두 마을 간에 항상 이동 가능한 경로가 있습니다.
    *   7. 1번 마을에 있는 음식점이 K 이하의 시간에 배달할 수 있는 마을 개수를 반환하면 됩니다.
    *
    *   - 시간 복잡도 분석
    *   E는 road의 길이입니다. 그래프를 추가할 때의 시간 복잡도는 O(E)이고, 다익스트라 알고리즘은 우선순위 큐를 활용했으므로 O((N + E)logN)입니다.
    *   그리고 마지막의 결과 리스트를 순회하며 K이하의 거리를 세는 연산은 O(N)입니다. 따라서 최종 시간 복잡도는 O((N + E)logN)입니다.
    */

    private static  class Node {
        int dest, cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }


    public static int solution(int N, int[][] road, int K) {
        // 1. 인접 리스트를 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. road 정보를 인접 리스트로 저장
        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        int[] dist = new int[N + 1];
        // 3. 모든 노드의 거리 값을 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 4. 우선순위 큐를 생성하고 시작 노드를 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost) {
                continue;
            }

            // 5. 인접한 노드들의 최단 거리를 갱신하고 우선순위 큐에 추가
            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;
        // 6. dist 배열에서 K 이하인 값의 개수를 구하여 반환
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}