package org.codingtest.graph;

import java.util.Arrays;

public class GraphMain {
    public static void main(String[] args) {
        System.out.println("--------------------그래프 11_4_34 깊이 우선 탐색 순회 Start--------------------");
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int start = 1, n = 5;
        System.out.println("결과 : " + Arrays.toString(깊이_우선_탐색_순회.solution(graph, start, n)));
        System.out.println("--------------------그래프 11_4_34 깊이 우선 탐색 순회 End----------------------");
        System.out.println("--------------------그래프 11_4_35 너비 우선 탐색 순회 Start--------------------");
        graph = new int[][]{{1, 3}, {3, 4}, {3, 5}, {5, 2}};
        System.out.println("결과 : " + Arrays.toString(너비_우선_탐색_순회.solution(graph, start, n)));
        System.out.println("--------------------그래프 11_4_35 너비 우선 탐색 순회 End----------------------");
        System.out.println("--------------------그래프 11_4_36 다익스트라 알고리즘 Start--------------------");
        graph = new int[][]{{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        start = 0;
        n = 3;
        System.out.println("결과 : " + Arrays.toString(다익스트라_알고리즘.solution(graph, start, n)));
        System.out.println("--------------------그래프 11_4_36 다익스트라 알고리즘 End----------------------");
    }
}