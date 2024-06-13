package org.codingtest.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class 길_찾기_게임 {

    /*
     *   길 찾기 게임
     *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/42892
     *
     *   - 시간 복잡도 분석
     *   N은 노드의 길이입니다. makeBT() 메서드를 보면 노드 번호 배열을 생성하고 정렬하기 위해 O(NlongN)이 필요합니다. 이후 각 노드를
     *   삽입할 때의 시간 복잡도는 O(N)이고 이를 N번 반복므로 시간 복잡도는 O(N^2)입니다. 그리고 트리를 구축하여 각각 순회하는 동작은 노드를
     *   한 번씩 방문하므로 O(N)입니다. 따라서 최종 시간 복잡도는 O(N^2)입니다.
     */

    // 1. Node 클래스 정의
    private static class Node {
        int x, y, num; // 노드의 좌표, 번호 저장
        Node left, right; // 노드의 왼쪽, 오른쪽 자식 노드

        public Node(int x, int y, int num) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    // 2. 이진 트리 생성 메서드
    private static Node makeBT(int[][] nodeInfo) {
        // 3. 각 노드에 대한 좌표, 번호를 배열에 저장
        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }

        // 4. y 기준으로 내림차순 정렬, y가 같다면 x를 기준으로 오름차순 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0]; // 맨 처음 노드는 무조건 루트

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            while (true) {
                // 5. 부모 노드의 x좌표가 더 크면 왼쪽으로
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else { // 6. 부모 노드의 x좌표가 더 작거나 같으면 오른쪽으로
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes[0];
    }

    // 7. 전위 순회 메서드
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    // 8. 후위 순회 메서드
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public static int[][] solution(int[][] nodeInfo) {
        Node root = makeBT(nodeInfo); // 이진 트리 생성
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList); // 전위 순회
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList); // 후위 순회

        // 9. 결과 반환
        int[][] answer = new int[2][nodeInfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}