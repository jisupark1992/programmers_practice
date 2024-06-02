package org.codingtest.hash;

public class HashMain {
    public static void main(String[] args) {
        System.out.println("--------------------해시 8_4_18 두 개의 수로 특정값 만들기 Start--------------------");
        int[] arr = {1, 2, 3, 4, 8};
        int target = 6;
        System.out.println("결과 : " + 두_개의_수로_특정값_만들기.solution(arr, target));
        System.out.println("--------------------해시 8_4_18 두 개의 수로 특정값 만들기 End--------------------");
        System.out.println("--------------------해시 8_4_19 완주하지 못한 선수 Start--------------------");
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println("결과 : " + 완주하지_못한_선수.solution(participant, completion));
        System.out.println("--------------------해시 8_4_19 완주하지 못한 선수 End--------------------");
    }
}