package org.codingtest.sort;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {

    /*  문자열로 구성된 리스트 strings와 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어
    *   strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
    *
    *   - 제약 조건
    *   1. strings는 길이 1이상, 50 이하인 배열입니다.
    *   2. strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
    *   3. strings의 원소는 길이 1이상, 100 이하인 문자열입니다.
    *   4. 모든 strings의 원소 길이는 n보다 큽니다.
    *   5. 인덱스 1의 문자가 같은 문자열이 여럿이면, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
    *
    *   - 시간 복잡도 분석
    *   N은 strings의 길이입니다. Arrays.sort() 메서드의 시간 복잡도를 고려하면 최종 시간 복잡도는 O(NlogN)입니다.
    */

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));

        return strings;
    }
}