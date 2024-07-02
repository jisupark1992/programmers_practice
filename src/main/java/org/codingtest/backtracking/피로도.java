package org.codingtest.backtracking;

public class 피로도 {

    /*  든든앤파이터라는 게임에는 피로도 시스템이 있습니다. 피로도는 정수로 표시하며 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
    *   각 던전마다 탐험을 시작하기 위해 필요한 최소 필요 피로도와 던전 탐험을 마쳤을 때 소모되는 소모 피로도가 있습니다. 예를 들어 최소
    *   필요 피로도가 80, 소모 피로도가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상이어야 하고, 던전을 탐험한 후에는
    *   피로도 20이 소모됩니다. 이 게임에는 하루에 한 번만 탐험할 수 있는 던전이 여러 개 있습니다. 한 유저가 오늘 던전을 최대한 많이 탐험하려
    *   합니다. 유저의 현재 피로도 k와 각 던전별 최소 필요 피로도, 소모 피로도가 담긴 2차원 배열 dungeons가 매개변수로 주어질 때 유저가
    *   탐험할 수 있는 최대 던전 수를 반환하는 solution() 함수를 완성하세요
    *
    *   - 제약 조건
    *   1. k는 1 이상 5,000 이하인 자연수입니다.
    *   2. dungeons의 세로 길이, 즉, 던전 개수는 1 이상 8 이하입니다.
    *       * dungeons의 가로 길이는 2입니다.
    *       * dungeons의 각 행은 각 던전의 [최소 필요 피로도, 소모 피로도]입니다.
    *       * 최소 필요 피로도는 항상 소모 피로도보다 크거나 같습니다.
    *       * 최소 필요 피로도와 소모 피로도는 1 이상 1,000 이하인 자연수입니다.
    *       * 서로 다른 던전의 [최소 필요 피로도, 소모 피로도]가 같을 수 있습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 던전의 개수입니다. 최악의 경우 모든 경로를 탐색하므로 경우의 수는 N * (N - 1) * ... * 1이므로 시간 복잡도는 O(N!)입니다.
    *   실제 연산은 유망 함수에 의해 훨씬 적습니다.
    */

    private static int answer;
    private static int[][] Dungeons;
    private static boolean[] visited;

    // 백트래킹을 위한 DFS
    private static void backtrack(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            // 1. 현재 피로도(k)가 i번째 던전의 최소 필요 피로도보다 크거나 같고,
            // i번째 던전을 방문한 적이 없다면
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true; // i번째 던전을 방문 ㅓ리
                // 2. 현재까지의 최대 탐험 가능 던전 수와
                // i번째 던전에서 이동할 수 있는 최대 탐험 가능 던전 수 중 큰 길을 선택하여 업데이트
                backtrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false; // 1번째 던전을 다시 방문 취소
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        Dungeons = dungeons;
        // 3. 던전 방문 여부를 저장할 배열
        visited = new boolean[Dungeons.length];

        backtrack(k, 0); // 4. DFS 메서드 수행
        return answer;
    }
}