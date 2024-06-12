package org.codingtest.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class 양과_늑대 {

    /*
     *   양과 늑대
     *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/92343
     *
     *   - 시간 복잡도 분석
     *   N은 info의 길이입니다. edges 배열을 순회하면서 트리를 생성하는 동적의 시간 복잡도는 O(N)입니다. 이후 너비 우선 탐색을 할 때의
     *   시간 복잡도는 O(N^2)입니다. 따라서 최종 시간 복잡도는 O(N^2)입니다.
     */

    // 현재 위치, 양의 수, 늑대의 수 방문한 노드 저장을 위한 클래스
    private static class Info {
       int node, sheep, wolf;
       HashSet<Integer> visited;

       public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
           this.node = node;
           this.sheep = sheep;
           this.wolf = wolf;
           this.visited = visited;
       }
    }

    private static ArrayList<Integer>[] tree; // 트리 정보를 저장할 연결 리스트

    // 1. 트리 구축 메서드
    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public static int solution(int[] info, int[][] edges) {
        buildTree(info, edges); // 2. 트리 생성
        int answer = 0; // 3. 최대 양의 수를 저장할 변수

        // 4. BFS를 위한 큐 생성 및 초기 상태 설정
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        // BFS(너비 우선 탐색) 시작
        while (!queue.isEmpty()) {
            // 5. 큐에서 현재 상태를 꺼냄
            Info now = queue.poll();
            // 6. 최대 양의 수 업데이트
            answer = Math.max(answer, now.sheep);
            // 7. 방문한 노드 집합에 현재 노드의 이웃 노드 추가
            now.visited.addAll(tree[now.node]);

            // 8. 인접한 노드들에 대해 탐색
            for (int next : now.visited) {
                // 9. 기존 해시셋의 데이터를 복사하고 현재 방문한 정점을 해시셋에서 제거
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if (info[next] == 1) { // 10. 늑대일 경우
                    if (now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}