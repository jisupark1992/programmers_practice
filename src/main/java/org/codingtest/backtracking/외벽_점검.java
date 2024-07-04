package org.codingtest.backtracking;

import java.util.Arrays;

public class 외벽_점검 {

    /*  레스토랑을 운영하는 스카피는 레스토랑 내부가 너무 낡아 친구들과 함께 직접 레스토랑을 리모델링하기로 했습니다. 레스토랑은 스노우타운이라는
    *   매우 추운 지역에 있어서 리모델링을 하는 중에 외벽 상태를 점검할 필요가 있습니다. 레스토랑의 구조는 완전히 동그란 모양이고 외벽의 총 둘레는
    *   n미터이며 외벽의 몇몇 지점은 추위가 심하면 손상될 수도 있는 취약한 지점들이 있습니다. 스카피는 외벽의 취약 지점들이 손상되지 않았는지 친구들을
    *   보내서 점검하기로 했습니다. 다만 빠른 공사 진행을 위해 점검 시간을 1시간만 하기로 했습니다. 친구들이 1시간 동안 이동할 수 있는 거리는
    *   제각각이므로 최소한의 친구들을 시켜 취약 지점을 점검하고 나머지 친구들은 리모델링을 하려고 합니다. 편의상 레스토랑의 정북 방향으로 지점을
    *   0으로 하여 취약 지점의 위치는 정북 방향 지점으로부터 시계 방향으로 떨어진 거리로 나타냅니다. 친구들은 출발 지점부터 시계 혹은 반시계 방향으로
    *   외벽을 따라서만 이동합니다. 외벽의 길이 n, 취약 지점의 위치가 담긴 배열 weak, 각 친구가 1시간 동안 이동할 수 있는 거리가 담긴 배열 dist가
    *   주어질 때 취약 지점을 점검하기 위해 보낼 친구 수의 최솟값을 반환하는 solution() 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. n은 1이상 200이하인 자연수입니다.
    *   2. weak의 길이는 1 이상 15 이하입니다.
    *       * 서로 다른 두 취약점의 위치가 같은 경우는 주어지지 않습니다.
    *       * 취약 지점의 위치는 오름차순으로 정렬되어 있습니다.
    *       * weak의 원소는 0 이상 n - 1 이하인 정수입니다.
    *   3. dist의 길이는 1 이상 8 이하입니다.
    *       * dist의 원소는 1 이상 100 이하인 자연수입니다.
    *   4. 친구들을 모두 투입해도 취약 지점을 전부 점검할 수 없는 때는 -1을 반환하세요.
    *
    *
    *   - 시간 복잡도 분석
    *   N은 dist의 길이이고, M은 weak의 길이입니다. weak 리스트에 항목을 추가하는 연산의 시간 복잡도는 O(M)입니다. 이후 반복문에서 모든
    *   weak 지점을 순회(M)하며 친구들의 순열을 모두 확인(N!)합니다. 그리고 현재 투입된 친구가 다음 weak까지 갈 수 있는지 체크하기 위한
    *   시간 복잡도는 M입니다. 따라서 최종 시간 복잡도는 O(M^2 * N!)입니다.
    */

    private static int length, answer;
    private static int[] Weak;
    private static boolean[] used;

    // 1. dist 배열의 친구들로 모든 외벽이 점검 가능한지 확인
    private static boolean check(int[] dist) {
        // 2. 점검을 시작하는 외벽을 0 부터 length 까지 전부 확인함
        for (int i =0; i < length; i++) {
            int idx = i;
            // 3. 각 친구가 점검 가능한 외벽을 모두 점검하여 진행
            for (int distance : dist) {
                int position = Weak[idx++] + distance;
                while (idx < Weak.length && Weak[idx] <= position) {
                    idx ++;
                }
            }
            // 4. 모든 외벽을 점검 가능하면 true 반환
            if (idx - 1 >= length) {
                return true;
            }
        }
        // 5. 모든 외벽을 점검할 수 없으면 false 반환
        return false;
    }

    // 6. n개의 숫자를 나열하는 모든 경우의 수를 구함
    private static void backtrack(int n, int[] dist, int[] org) {
        if (n == org.length) {
            // 7. 모든 외벽이 점검 가능하면 답 저장
            if (check(dist)) {
                answer = n;
            }
            return;
        }

        // 8. 한 번 사용한 친구는 다시 사용하지 않도록 used 배열을 활용하여 백트래킹
        for (int i = 0; i < org.length; i++) {
            if (!used[i]) {
                used[i] = true;
                dist[n] = org[i];
                backtrack(n + 1, dist, org);
                used[i] = false;
            }
        }
    }

    public static int solution(int n, int[] weak, int[] dist) {
        // 9. 주어진 weak 지점들을 선형으로 만들어 줌
        length = weak.length;
        Weak = new int[length * 2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                Weak[j + (i * length)] = weak[j] + (i * n);
            }
        }

        // 10. 오름차순으로 정렬
        Arrays.sort(dist);
        answer = -1; // 답을 -1 로 초기화
        used = new boolean[dist.length]; // used 배열 생성

        // 11. 가장 점검 범위가 큰 친구부터 1명 씩 늘려가며 답을 탐색
        for (int i = 0; i <= dist.length; i++) {
            int[] org = new int[i];
            System.arraycopy(dist, dist.length - i, org, 0, i);
            backtrack(0, new int[i], org);
            if (answer > 0) { // 답을 찾았으면 종료해야 함
                break;
            }
        }
        return answer;
    }
}