package org.codingtest.set;

import java.util.Arrays;

public class SetMain {
    public static void main(String[] args) {
        System.out.println("--------------------집합 10_3_30 간단한 유니온-파인드 알고리즘 구현하기 Start--------------------");
        int[][] operations = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        System.out.println("결과 : " + Arrays.toString(간단한_유니온_파인드_알고리즘_구현하기.solution(3, operations)));
        System.out.println("--------------------집합 10_3_30 간단한 유니온-파인드 알고리즘 구현하기 End----------------------");
        System.out.println("--------------------집합 10_4_31 폰켓몬 Start--------------------");
        int[] nums = {3, 1, 2, 3};
        System.out.println("결과 : " + 폰켓몬.solution(nums));
        System.out.println("--------------------집합 10_4_31 폰켓몬 End----------------------");
        System.out.println("--------------------집합 10_4_32 영어 끝말잇기 Start--------------------");
        int n = 3;`
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println("결과 : " + Arrays.toString(영어_끝말잇기.solution(n, words)));
        System.out.println("--------------------집합 10_4_32 영어 끝말잇기 End----------------------");
        System.out.println("--------------------집합 10_4_33 섬 연결하기 Start--------------------");
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println("결과 : " + 섬_연결하기.solution(4, costs));
        System.out.println("--------------------집합 10_4_33 섬 연결하기 End----------------------");
    }
}