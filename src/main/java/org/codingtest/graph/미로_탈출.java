package org.codingtest.graph;

import java.util.ArrayDeque;

public class 미로_탈출 {

    /*  1 x 1 크기의 직사각형들로 이루어진 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며 벽으로 된 칸은
    *   지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로 중 한 칸에는 미로를 빠져나가는 문이 있는데 이 문은 레버를 당겨서만 열 수 있습니다.
    *   레버 또한 통로 중 한 칸에 있습니다. 따라서 출발 지점에서 먼저 레버가 있는 칸으로 이동해 레버를 당긴 후 미로를 빠져나가는 문이 있는
    *   칸으로 이동해 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을
    *   지나갈 수 있습니다. 미로에서 한 칸을 이동하는 데 1초가 걸린다고 할 때 최대한 빠르게 미로를 빠져나가는 데 걸리는 시간을 구하려 합니다.
    *   미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때 미로를 탈출하는데 필요한 최소 시간을 반환하는 solution() 함수를 완성하세요.
    *   만약 탈출할 수 없다면 -1을 반환하세요.
    *
    *   - 제약 조건
    *   1. 5 <= maps의 길이 <= 100
    *       * 5 <= maps[i]의 길이 <= 100
    *       * maps[i]는 다음 5개의 문자로 구성
    *        - S: 시작 지점, E: 출구, L: 레버, O: 통로, X: 벽
    *       * 시작 지점과 출구, 레버는 항상 다른곳에 있으며 1개씩만 있음
    *       * 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있음
    *
    *   - 시간 복잡도 분석
    *   N은 지도 한번의 길이입니다. 이동 과정은 최악의 경우 지도의 크기가 N * N, 네방향으로 이동하므로 시간 복잡도는 O(4 * N^2)이 되므로
    *   이를 정리하면 최종 시간 복잡도는 O(N^2)입니다.
    */

    // 1. 위, 아래, 왼쪽, 오른쪽 이동 방향
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    // 2. 위치 정보(x, y)를 저장할 클래스 생성
    private static class Point {
        int nx, ny;

        public Point(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }

    private static char[][] map;
    private static int N, M;

    public static int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        // 3. 미로에 대한 정보를 배열로 저장
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        Point start = null, end = null, lever = null;

        // 4. 시작 지점, 출구 그리고 레버의 위치를 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') start = new Point(j, i);
                else if (map[i][j] == 'E') end = new Point(j, i);
                else if (map[i][j] == 'L') lever = new Point(j, i);
            }
        }

        // 5. 시작 지점 -> 레버, 레베 -> 출구까지의 최단 거리를 각각 구함
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);

        // 6. 도착 불가능한 경우는 -1, 도착 가능한 경우는 최단 거리를 반환
        if (startLever == -1 || leverEnd == -1) {
            return -1;
        } else {
            return startLever + leverEnd;
        }
    }

    // start -> end로 너비 우선 탐색하여 최단거리 반환
    private static int bfs(Point start, Point end) {
        // 7. 너비 우선 탐색 초기 과정
        int[][] dist = new int[N][M];
        ArrayDeque<Point> queue = new ArrayDeque<>();
        dist[start.ny][start.nx] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            // 8. 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];

                // 9. 범위를 벗어나는 경우 예외 처리
                if (nextX < 0 || nextX >= M || nextY <0 || nextY >= N) {
                    continue;
                }

                // 10. 이미 방문한 지점인 경우 탐색하지 않음
                if (dist[nextY][nextX] > 0) {
                    continue;
                }

                // 11. X가 아닌 지점만 이동 가능
                if (map[nextY][nextX] == 'X') {
                    continue;
                }

                // 12. 거리 1 증가
                dist[nextY][nextX] =dist[now.ny][now.nx] + 1;

                // 13. 다음 정점을 큐에 넣음
                queue.add(new Point(nextX, nextY));

                // 14. 도착점에 도달하면 최단 거리를 반환
                if (nextX == end.nx && nextY == end.ny) {
                    return dist[end.ny][end.nx] - 1;
                }
            }
        }

        // 15. 탐색을 종료할 때까지 도착 지점에 도달하지 못했다면 -1 반환
        return -1;
    }
}