package org.codingtest.tree;

import java.util.Arrays;

public class TreeMain {
    public static void main(String[] args) {
        System.out.println("--------------------트리 9_4_25 트리 순회 Start--------------------");
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("결과 : " + Arrays.toString(트리_순회.solution(nodes)));
        System.out.println("--------------------트리 9_4_25 트리 순회 End--------------------");
        System.out.println("--------------------트리 9_5_26 예상 대진표 Start--------------------");
        int n = 8, a = 4, b = 7;
        System.out.println("결과 : " + 예상_대진표.solution(n, a, b));
        System.out.println("--------------------트리 9_5_26 예상 대진표 End--------------------");
        System.out.println("--------------------트리 9_5_27 다단계 칫솔 판매 Start--------------------");
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println("결과 : " + Arrays.toString(다단계_칫솔_판매.solution(enroll, referral, seller, amount)));
        System.out.println("--------------------트리 9_5_27 다단계 칫솔 판매 End--------------------");
        System.out.println("--------------------트리 9_5_28 양과 늑대 Start--------------------");
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        System.out.println("결과 : " + 양과_늑대.solution(info, edges));
        System.out.println("--------------------트리 9_5_28 양과 늑대 End--------------------");
        System.out.println("--------------------트리 9_5_29 길 찾기 게임 Start--------------------");
        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        System.out.println("결과 : " + Arrays.deepToString(길_찾기_게임.solution(nodeInfo)));
        System.out.println("--------------------트리 9_5_29 길 찾기 게임 End--------------------");
    }
}