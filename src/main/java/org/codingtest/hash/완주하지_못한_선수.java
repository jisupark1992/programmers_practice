package org.codingtest.hash;

import java.util.HashMap;

public class 완주하지_못한_선수 {

    /*  많은 선수 중 단 한 명의 선수를 제외하고 모든 선수가 마라톤을 완주하였습니다. 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한
    *   선수들의 이름이 담긴 배열 completion이 있을 때 완주하지 못한 선서의 이름을 반환하는 solution() 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. 마라톤 경기에 참여한 선수 수는 1명 이상 100,000명 이하입니다.
    *   2. completion 길이는 participant 길이보다 1 작습니다.
    *   3. 참가자 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    *   4. 참가자 중에는 동명이인이 있을 수 있습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 particiapnt의 길이이고, K는 completion의 길이입니다. 완주한 선수들의 이름을 해시맵에 추가하는 연산의 시간 복잡도는 O(K)이고
    *   참가자의 이름을 해시맵에서 제외하는 연산의 시간 복잡도는 O(N)입니다. 추가로 completion의 최대 길이는 N - 1이므로 K 대신 N - 1로
    *   대체하면 시간 복잡도는 O(2 * (N - 1))입니다. 최종 시간 복잡도는 O(N)가 됩니다.
    */
    public static String solution(String[] participant, String[] completion) {
        // 1. 해시맵 생성
        HashMap<String, Integer> hashMap = new HashMap();
        // 2. 완주한 선수들의 이름을 해시맵에 저장
        for (String s : completion) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        // 3. 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
        for (String s : participant) {
            // 4. 완주하지 못한 선수를 찾으면 반환
            if (hashMap.getOrDefault(s, 0) == 0) {
                return s;
            }
            hashMap.put(s, hashMap.get(s) - 1);
        }

        return null;
    }
}