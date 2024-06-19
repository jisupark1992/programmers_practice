package org.codingtest.set;

import java.util.Arrays;

public class 섬_연결하기 {

    /*  n개의 섬 사이에 다리를 건설하는 비용 costs가 주어질 때 최소 비용으로 모든 섬이 서로 통행하는 solution() 함수를 완성하세요. 다리를
    *   여러 번 건너더라도 목표 지점에 도달할 수만 있으면 통행할 수 있다고 봅니다. 예를 들어 A, B 섬 사이에 다리가 있고, B, C 섬 사이에 다리가
    *   있으면 A, C 섬은 서로 통행할 수 있습니다.
    *
    *   - 제약 조건
    *   1. 섬 개수 n은 1 이상 100 이하입니다.
    *   2. costs의 길이는 ((n - 1) * n) / 2 이하입니다.
    *   3. 임의의 1에 대해, costs[i][1]에는 다리가 연결되는 두 섬의 번호가 들어 있고, costs[i][2]에는 이 두섬을 연결하는 다리를 건설할 때 드는 비용입니다.
    *   4. 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
    *   5. 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
    *   6. 연결할 수 없는 섬은 주어지지 않습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 노드 개수, E는 costs의 길이, 즉 간선 개수입니다. 간선을 비용 기준으로 정렬하기 위한 시간 복잡도는 O(ElogE)입니다. 그다음 costs를
    *   순회하면서 find(), union() 메서드를 호출하기 위한 시간 복잡도는 O(ElogE)입니다. 따라서 최종 시간 복잡도는 O(ElogE)입니다.
    */
    private static int[] parent;

    private static int find(int x) {
        // 1. x가 속한 집합의 루트 노드 찾기
        if (parent[x] == x) {
            return x;
        }
        // 2. 경로 압축 : x의 부모를 루트로 설정
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        // 3. 두 집합을 하나의 집합으로 합치기
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static int solution(int n, int[][] costs) {
        // 4. 비용을 기준으로 다리를 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 5. parent 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0; // 최소 신장 트리의 총비용
        int edges = 0; // 연결된 다리의 수

        for (int[] edge : costs) {
            // 6. n - 1개의 다리가 연결된 경우 모든 섬이 연결됨
            if (edges == n -1) {
                break;
            }

            // 7. 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 확인
            if (find(edge[0]) != find(edge[1])) {
                // 8. 두 섬을 하나의 집합으로 연결함
                union(edge[0], edge[1]);
                // 9. 현재 다리의 건설 비용을 총비용에 추가
                answer += edge[2];
                // 10. 사용된 다리의 수 1증가
                edges++;
            }
        }

        return answer;
    }
}