package org.codingtest.sort;

import java.util.PriorityQueue;

public class 지형_이동 {

    /*
    *   N x N 크기의 정사각 격자 형태의 지형이 있습니다. 각 격자의 칸은 1 x 1 크기이며 숫자가 하나씩 적혀 있습니다. 숫자는 그 칸의 높이를
    *   나타냅니다. 이 지형의 아무 칸에서나 출발해 모든 칸을 방문하는 탐험을 떠나려합니다. 칸을 이동할 때는 상, 하, 좌, 우로 한 칸씩 이동할
    *   수 있는데, 현재 칸과 이동하려는 칸의 높이 차이가 height 이하여야 합니다. 높이 차이가 height보다 많이 나면 사다리를 설치해서 이동할 수 있습니다.
    *   이때 사다리를 설치하면 두 격자 칸의 높이 차이만큼의 비용이 듭니다. 따라서, 최대한 적은 비용이 들드록 사다리를 설치해서 모든 칸으로 이동할
    *   수 있도록 해야 합니다. 설치할 수 있는 사다리 개수에 제한은 없으며, 설치한 사다리는 철거하지 않습니다. 각 격자 칸의 높이가 담긴 2차원
    *   배열 land와 이동 가능한 최대 높이차 height가 주어질 때 모든 칸을 방문하기 위해 필요한 사다리 설치 비용의 최솟값을 반환하는
    *   solution() 함수를 완성해주세요.
    *
    *   - 제약 조건
    *   1. land는 N x N 크기인 2차원 배열입니다.
    *   2. land의 최소 크기는 4 x 4, 최대 크기는 300 x 300입니다.
    *   3. land의 원소는 각 격자 칸의 높이를 나타냅니다.
    *   4. 격자 칸의 높이는 1 이상 10,000 이하인 자연수입니다.
    *   5. height는 1 이상 10,000 이하인 자연수입니다.
    *
    *   - 시간 복잡도
    *   N은 land의 한 변의 길이입니다. 각 지점을 방문하는데 필요한 시간 복잡도는 O(N^2)이고 우선순위 큐를 활용해 너비 우선 탐색을 진행하므로
    *   최종 시간 복잡도는 O(N^2log(N^2))입니다.
    */

    private static class Node {
        int i, j, cost;
        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    public static int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        // 1. 주변 노드 탐색을 위한 di, dj
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][n];

        // 2. 시작 노드 추가
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));

        // 3. BFS + 우선순위 큐로 다음 노드 관리
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            // 4. 아직 방문하지 않은 경로만 탐색
            if (visited[now.i][now.j]) {
                continue;
            }

            visited[now.i][now.j] = true;
            // 5. 현재까지 비용을 합산
            answer += now.cost;

            for (int i = 0; i < 4; i++) {
                int ni = now.i + di[i];
                int nj = now.j + dj[i];

                // 6. 유효한 인덱스가 아닐 경우
                if (!(0 <= ni && ni < n && 0 <= nj && nj < n)) {
                    continue;
                }

                int tempCost = Math.abs(land[now.i][now.j] - land[ni][nj]);
                // 7. 입력으로 주어진 height보다 높이차가 큰 경우
                int newCost = tempCost > height ? tempCost : 0;
                // 8. 다음 경로를 add
                pq.add(new Node(ni, nj, newCost));
            }
        }

        return answer;
    }
}