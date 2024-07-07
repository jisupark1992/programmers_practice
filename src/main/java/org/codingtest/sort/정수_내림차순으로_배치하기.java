package org.codingtest.sort;

import java.util.Arrays;
import java.util.Collections;

public class 정수_내림차순으로_배치하기 {

    /*  정수 n을 받아 n의 각 자릿수를 내림차순으로 정렬한 새로운 정수를 반환하세요 예를 들어 n이 118372면 873211을 반환하면 됩니다.
    *
    *   - 제약 조건
    *   1. n은 1이상 8,000,000,000 이하인 자연수입니다.
    *
    *   - 시간 복잡도 분석
    *   N은 strings의 길이입니다. Arrays.sort() 메서드의 시간 복잡도를 고려하면 최종 시간 복잡도는 O(NlogN)입니다.
    */

    public static long solution(long n) {
        // 1. 정수 n을 문자열로 변환하고 각 자릿수를 배열로 저장
        String[] digits = String.valueOf(n).split("");

        // 2. 내림차순으로 정렬
        Arrays.sort(digits, Collections.reverseOrder());

        // 3. 정렬된 숫자를 다시 하나의 문자열로 합침
        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }

        // 4. 문자열을 long형으로 변환하여 반환
        return Long.parseLong(sb.toString());
    }
}