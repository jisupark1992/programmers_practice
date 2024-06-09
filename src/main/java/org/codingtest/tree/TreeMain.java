package org.codingtest.tree;

import java.util.Arrays;

public class TreeMain {
    public static void main(String[] args) {
        System.out.println("--------------------트리 9_4_25 트리 순회 Start--------------------");
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("결과 : " + Arrays.toString(트리_순회.solution(nodes)));
        System.out.println("--------------------트리 9_4_25 트리 순회 End--------------------");
    }
}