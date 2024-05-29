package org.codingtest.queue;

import java.util.Arrays;

public class QueueMain {
    public static void main(String[] args) {
        System.out.println("--------------------큐 7_2_15 요세푸스 문제 Start--------------------");
        int N = 5, K = 2;
        System.out.println("결과 : " + 요세푸스_문제.solution(N, K));
        System.out.println("--------------------큐 7_2_15 요세푸스 문제 End--------------------");
        System.out.println("--------------------큐 7_3_16 기능 개발 Start--------------------");
        int[] progresses = {93, 30, 55}, speeds = {1, 30, 5};
        System.out.println("결과 : " + Arrays.toString(기능_개발.solution(progresses, speeds)));
        System.out.println("--------------------큐 7_3_16 기능 개발 End--------------------");
    }
}