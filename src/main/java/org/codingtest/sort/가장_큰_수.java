package org.codingtest.sort;

import java.util.ArrayList;

public class 가장_큰_수 {

    /*  0 또는 양의 정수가 주어졌을 때 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내세요. 예를 들어 [6, 10, 2]가 주어졌다면
    *   [6102, 6210, 6062, 1026, 2610, 2106]을 만들 수 있으며 이 중 가장 큰 수는 6210입니다. 0 또는 양의 정수가 담긴 배열 numbers가
    *   주어질 때 순서를 재배치해 만들 수 있는 가장 큰 수를 문자열로 바꾸어 반환하는 solution() 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. numbers의 길이는 1 이상 100,000 이하입니다.
    *   2. numbers의 원소는 0 이상 1,000 이하입니다.
    *   3. 정답이 너무 클 수 있으니 문자열로 바꾸어 반환합니다.
    *
    *   - 시간 복잡도 분석
    *   N은 numbers의 길이입니다. sort() 메서드에서 Comparator를 기준으로 정렬하고 있습니다. Comparator는 람다식으로 구현했고 두 문자열을
    *   조합한 후 int형으로 변환하여 비교하는 메서드입니다. 각 수는 최댓값이 1,000이므로 문자열을 합칠 경우 최대 문자열의 길이는 7입니다.
    *   데이터가 N개일 때 정렬에 필요한 시간 복잡도는 O(NlogN)입니다. 따라서 최종 시간 복잡도는 O(7NlogN)이지만 N이 7에 비해 훨씬 크므로
    *   O(NlogN)으로 표시해도 됩니다.
    */

    public static String solution(int[] numbers) {
        // 1. int형 정수 배열을 문자열로 바꾸어 list에 저장
        ArrayList<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        // 2. 조합하여 비교하여 더 큰 수를 기준으로 내림차순 정렬
        list.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });

        // 3. 정렬된 수를 나열하여 문자열로 만듬
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        // 4. 문자열을 반환, 맨 앞에 "0"이 있는 경우는 "0"만 반환
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}