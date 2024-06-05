package org.codingtest.hash;

import java.util.Arrays;

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
        System.out.println("--------------------해시 8_5_20 할인 행사 Start--------------------");
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        String[] discount = {"chicken", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int[] number = {3, 2, 2, 2, 1};
        System.out.println("결과 : " + 할인_행사.solution(want, number, discount));
        System.out.println("--------------------해시 8_5_20 할인 행사 End--------------------");
        System.out.println("--------------------해시 8_5_21 오픈 채팅방 Start--------------------");
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println("결과 : " + Arrays.toString(오픈_채팅방.solution(record)));
        System.out.println("--------------------해시 8_5_21 오픈 채팅방 End--------------------");
        System.out.println("--------------------해시 8_5_22 베스트 앨범 Start--------------------");
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println("결과 : " + Arrays.toString(베스트_앨범.solution(genres, plays)));
        System.out.println("--------------------해시 8_5_22 베스트 앨범 End--------------------");
    }
}