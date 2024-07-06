package org.codingtest.sort;

public class 계수_정렬_구현하기 {

    /*  인자로 받은 문자열 s를 계수 정렬로 정렬하여 반환하는 solution() 함수를 구현하세요.
    *
    *   - 제약 조건
    *   1. string의 길이는 1이상 10,000 이하입니다.
    *   2. s는 알파벳 소문자로 이루어져 있습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 S의 길이입니다. count 배열을 초기화할 때의 시간 복잡도는 O(26)이고, 이후 문자열을 순회하면서 빈도수 배열을 만드는 시간 복잡도는
    *   O(N)입니다. 빈도수 배열을 순회하면서 정렬하기 위한 시간 복잡도는 O(26 + N)입니다. 따라서 최종 시간 복잡도는 O(N)입니다.
    */

    public static String solution(String s) {
        int[] counts = new int[26]; // 1. 알파벳 개수(26개)만큼 빈도수 배열 생성

        // 2. 문자열의 각 문제에 대한 빈도수를 count배열에 저장
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // 3. 빈도수 배열을 순회하면서 정렬된 문자열을 생성
        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char)(i + 'a'));
            }
        }

        return sortedStr.toString();
    }
}