package org.codingtest.graph;

import java.util.ArrayDeque;

public class 경주로_건설 {

    /*
    *   경주로 건설
    *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/67259
    *
    *   - 제약 조건
    *   1. board는 2차원 정사각 배열로 크기는 3 이상 25 이하입니다.
    *   2. board 배열의 각 원소의 값은 0 또는 1입니다.
    *       * 도면의 가장 왼쪽 상단 좌표는 (0, 0)이며, 가장 우측 하단 좌표는 (N - 1, N - 1)입니다.
    *       * 원소의 값 0은 칸이 비어 있어 도로 연결이 가능함을, 1은 칸이 벽으로 채워져 있어 도로 연결이 불가능함을 나타냅니다.
    *   3. board는 항상 출발점에서 도착점까지 경주로를 건설할 수 있는 형태로 주어집니다.
    *   4. 출발점과 도착점 칸의 원소의 값은 항상 0으로 주어집니다.
    *
    *   - 시간 복잡도 분석
    *   보드의 한 변의 길이를 N이라고 하면 너비 우선 탐색은 N * N개의 노드를 탐색하고 네 방향을 고려하므로 시간 복잡도는 O(N^2)입니다.
    */

    private static  class Node {
        int x, y, direction, cost;
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }

    // 순서는 반드시 (0, -1), (-1, 0), (0, 1), (1, 0) 순서로 코너 계산에 필요.
    private static final int[] rx = {0, -1, 0, 1};
    private static final int[] ry = {-1, 0, 1, 0};
    private static int N;
    private static int[][][] visited;

    // 1. 주어진 좌표가 보드의 범위 내에 있는지 확인
    private static boolean isVaild(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    // 2. 주어진 좌표가 차단되었거나 이동할 수 없는지 확인
    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isVaild(x, y) || board[x][y] == 1;
    }

    // 3. 이전 방향과 현재 방향에 따라 비용 계산
    private static int calculateCost(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
            return cost + 100;
        }
        return cost + 600;
    }

    // 4. 주어진 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }

    public static int solution(int[][] board) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];

        int answer = Integer.MAX_VALUE;

        // 5. 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 6. 가능한 모든 방향에 대해 반복
            for (int i = 0; i < 4; i++) {
                int new_x = now.x + rx[i];
                int new_y = now.y + ry[i];

                // 7. 이동할 수 없는 좌표는 건너뛰기
                if (isBlocked(board, new_x, new_y)) {
                    continue;
                }

                int new_cost = calculateCost(i, now.direction, now.cost);

                // 8. 도착지에 도달한 경우 최소 비용 업데이트
                if (new_x == N - 1 && new_y == N -1) {
                    answer = Math.min(answer, new_cost);
                }

                // 9. 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 적은 경우 큐에 추가
                else if (isShouldUpdate(new_x, new_y, i, new_cost)) {
                    queue.add(new Node(new_x, new_y, i, new_cost));
                    visited[new_x][new_y][i] = new_cost;
                }
            }
        }

        return answer;
    }
}