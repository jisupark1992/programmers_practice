package org.codingtest.graph;

public class 네트워크 {

    /*  네트워크란 컴퓨터 상호 간에 정보를 교환하도록 연결된 어떤 형태를 의미합니다. 예를 들어 컴퓨터 A, B가 직접 연결되어 있고 컴퓨터 B, C가
    *   직접 연결되어 있을 때 컴퓨터 A, C는 간접 연결되어 있어 정보를 교환할 수 있습니다. 그러면 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고
    *   할 수 있습니다. 컴퓨터 개수가 n, 연결 정보가 담긴 2차원 배월 computers가 주어질 때 네트워크 개수를 반환하는 solution()함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
    *   2. 각 컴퓨터는 0부터 n - 1인 정수로 표현합니다.
    *   3. i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
    *   4. computers[i][i]는 항상 1입니다.
    *
    *   - 시간 복잡도 분석
    *   노드의 개수를 N, 간선의 개수를 E라고 하면 인접 행렬로 깊이 우선 탐색은 노드의 연결 여부에 상관없이 모두 체크하므로 시간 복잡도는 O(N^2)입니다.
    *   여기서도 computers의 정보가 인접 행렬로 되어있으니 시간 복잡도는 O(N^2)입니다. N이 최대 200이므로 사실 시간 복잡도는 크게 관계가 없는 문제입니다.
    */

    private static boolean[] visit;
    private static int[][] computer;

    private static void dfs(int now) {
        visit[now] = true; // 1. 현재 노드 방문 처리
        for (int i = 0; i < computer[now].length; i++) {
            // 2. 연결되어 있으며 방문하지 않은 노드라면
            if (computer[now][i] == 1 && !visit[now]) {
                dfs(i); // 3. 해당 노드를 방문하러 이동
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visit = new boolean[n]; // 4. 방문 여부를 저장할 배열

        for (int i = 0; i < n; i++) {
            if (!visit[i]) { // 5. 아직 방문하지 않은 노드라면 해당 노드를 시작으로 깊이 우선 탐색 진행
                dfs(i);
                answer++; // 6. DFS로 연결된 노드들을 모두 방문하면서 네트워크 개수 증가
            }
        }

        return answer;
    }
}