package org.codingtest.set;

import java.util.ArrayList;

public class 간단한_유니온_파인드_알고리즘_구현하기 {

    /*  상호배타적 집합을 표현하고 관리하는 데 다음 두 연산이 필요합니다.
    *       * union(x,y) : x와 y가 속한 두 집합을 합칩니다.
    *       * find(x) : x가 속한 집합의 대표 원소를 찾습니다.
    *   operations라는 배열은 수행할 연산을 의미합니다. 연산 종류는 2개입니다.
    *       * [0, 1, 2]은 노드 1과 노드 2에 대해 union 연산 수행
    *       * [1, 1, 3]노드 1과 3이 같은 집합에 속해 있으면 true 아니면 false를 반환하는 equals 연산
    *   초기의 노드는 부모 노드를 자신의 값으로 설정했다고 가정하며, 여기서는 각 집합의 루트노드를 기준으로 루트 노드가 작은 노드를 더 큰
    *   노드의 자식으로 연결하는 방법을 사용합니다. operations에 있는 연산에 대한 결과를 연산 순서대로 담은 Boolean 배열을 반환하는
    *   solution() 메서드를 구현해주세요.
    *
    *
    *   - 제약 조건
    *   1. 0 <= k <= 1,000 : 노드의 개수
    *   2. 1 <= len(operations) <= 100,000
    *   3. operations[i][0]은 문자열 'u' 또는 'i' 중 하나
    *   4. 0은 union 연산, union 연산 뒤로는 두 개의 정수 x, y가 나옴
    *   5. 1은 equals 연산, equals 연산 뒤로는 두 개의 정수 x, y가 나옴
    *   6. x와 y는 0이상 k-1 이하의 정수
    *   7. 연산은 항상 유효함
    *       * 즉, union, find 연산의 인수는 상호배타적 집합 내에 있는 노드 번호
    *
    *   - 시간 복잡도 분석
    *   N은 operations의 길이입니다. find() 메서드, union 메서드의 시간 복잡도는 O(lonN)입니다. 다음으로 solution() 메서드에서 각
    *   operations에 usnion()이나 find() 연산을 하는 부분의 시간 복잡도는 O(NlongN)이고, 마지막에 find() 연산을 추가로 하므로 시간
    *   복잡도는 O(KlogN)입니다. 이를 종합하면 O(NlogN + KlogN)입니다만 N이 K에 비해 상대적으로 크므로 O(NlogN)이라고 봐도 됩니다.
    */

    // 부모 저장을 위한 배열
    private static int[] parent;

    // 루트 노드를 찾는 매서드
    private static int find(int x) {
        //만약 x의 부모가 자기 자신이면, 즉 x가 루트 노드라면 x를 반환
        if(parent[x] == x) {
            return x;
        }
        // 그렇지 않다면 x의 부모를 찾아서 parent[x]에 저장합니다.
        parent[x] = find(parent[x]);
        return parent[x]; //찾은 루트 노드를 반환
    }

    private static void union(int x, int y) {
        int root1 = find(x); // x가 속한 집합의 루트 노드 찾기
        int root2 = find(y); // y가 속한 집합의 루트 노드 찾기
        parent[root2] = root1; // y가 속한 집합을 x가 속한 집하에 합침
    }

    public static Boolean[] solution(int k, int[][] operations) {
        // 노드의 수 만큼 배열 생성
        parent = new int[k];
        // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operations) {
            if (op[0] == 0) { // 0 연산이면
                union(op[1], op[2]);
            } else { // 1 연산이면
                answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }
}