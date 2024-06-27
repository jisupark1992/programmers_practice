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
        System.out.println("--------------------그래프 11_5_37 게임 맵 최단 거리 Start--------------------");
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println("결과 : " + 게임_맵_최단_거리.solution(maps));
        System.out.println("--------------------그래프 11_5_37 게임 맵 최단 거리 End----------------------");
        System.out.println("--------------------그래프 11_5_38 네트워크 Start--------------------");
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println("결과 : " + 네트워크.solution(n, computers));
        System.out.println("--------------------그래프 11_5_38 네트워크 End----------------------");
        System.out.println("--------------------그래프 11_5_39 미로 탈출 Start--------------------");
        String[] strMaps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        System.out.println("결과 : " + 미로_탈출.solution(strMaps));
        System.out.println("--------------------그래프 11_5_39 미로 탈출 End----------------------");
        System.out.println("--------------------그래프 11_5_40 배달 Start--------------------");
        int N = 5, K = 3;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        System.out.println("결과 : " + 배달.solution(N, road, K));
        System.out.println("--------------------그래프 11_5_40 배달 End----------------------");
    }
}