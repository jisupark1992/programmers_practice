package org.codingtest.graph;

import java.util.ArrayDeque;

public class 게임_맵_최단_거리 {

    /*
    *   게임 맵 최단 거리
    *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
    *
    *   - 제약 조건
    *   1. maps는 n x m 크기의 게임 맵읩 상태가 들어있는 2차원 배열로, n과 m은 각각 1이상 100이하의 자연수입니다.
    *       * n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
    *   2. maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
    *   3. 처음에 캐릭터는 게임 맵의 좌측 상당인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
    *
    *   - 시간 복잡도 분석
    *   배열의 크기를 N * M이라고 하면 dist 배열을 초기화할 때의 시간 복잡도는 O(N * M)이고, 너비 우선 탐색을 할 때는 최악의 경우 dist의
    *   모든 위치가 큐에 들어가는 경우이므로 너비 우선 탐색의 시간 복잡도는 O(N * M)입니다. 따라서 최종 시간 복잡도는 O(N * M)입니다.
    */

    // 1. 이동할 수 있는 방향을 나타내는 배열 rx, ry 선언
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static  class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static int solution(int[][] maps) {
        // 2. 맵의 크기를 저장하는 변수 선언
        int N = maps.length;
        int M = maps[0].length;

        // 3. 최단 거리를 저장할 배열 생성
        int[][] dist = new int[N][M];

        // 4. bfs 탐색을 위한 큐 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 5. 시작 장점에 대해서 큐에 추가, 최단 거리 저장
        queue.addLast(new Node(0, 0));
        dist[0][0] = 1;

        // 6. queue가 빌 때까지 반복
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // 7. 현재 위치에서 이동할 수 있는 모든 방향
            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 8. 맵 밖으로 나가는 경우 예외 처리
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                // 9. 백으로 가는 경우 예외 처리
                if (maps[nr][nc] == 0) {
                    continue;
                }

                // 10. 이동한 위치가 처음 방문하는 경우, queue에 추가하고 거리 갱신
                if (dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        // 목적지까지 최단 거리 반환, 목적지에 도달하지 못한 경우에는 -1 반환
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}