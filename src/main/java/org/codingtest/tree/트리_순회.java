package org.codingtest.tree;

public class 트리_순회 {

    /*  이진 트리를 표현한 리스트 nodes를 인자로 받습니다. 예를 들어서 nodes가 [1, 2, 3, 4, 5, 6, 7]이면 다음과 같은 트리를 표현한
    *   것입니다. 해당 이천 트리에 대하여 전위 순회, 중위 순회, 후위 순회 결과를 반환하는 solution()함수를 구현하세요.
    *
    *   - 제약 조건
    *   1. 입력 노드값의 개수는 1개 이상 1,000개 이하이다.
    *   2. 노드값은 정수형이며, 중복되지 않는다.
    *
    *   - 시간 복잡도 분석
    *   N은 노드의 개수입니다. 전위, 중위, 후위 연산 모두 각 노드를 한 번씩 방문하므로 시간 복잡도는 O(N)입니다.
    */
    public static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();

        return result;
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 루트 노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어 붙임
        return nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 왼쪽 서브 트리 -> 루트 노드 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어 붙임
        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 루트 노드 순으로 재귀 호출하여 결과를 이어 붙임
        return postorder(nodes, 2 * idx + 1) + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }
}