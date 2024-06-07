package org.codingtest.hash;

import java.util.*;

public class 메뉴_리뉴얼 {

    /*
     *   신고_결과_받기
     *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/72411
     *
     *   - 제약 조건
     *   1. orders 배열의 크기는 2 이상 20 이하입니다.
     *   2. orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
     *      * 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
     *      * 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
     *   3. course 배열의 크기는 1 이상 10 이하입니다.
     *      * course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
     *      * course 배열에는 같은 값이 중복해서 들어있지 않습니다.
     *   4. 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
     *      * 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
     *      * 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
     *      * orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
     *
     *   - 시간 복잡도 분석
     *   N은 orders의 길이, K는 course의 최대 크기, M은 orders 원소 하나의 최대 길이입니다. 이 값과 함께 이중 반목문을 돌면서
     *   orders의 각 원소를 정렬하고 combination()를 실행하기 위한 시간 복잡도는 O(K * N * (MlogM + 2^M))입니다. 다음으로 couresMap
     *   에서 최대값을 찾는 작업은 O(N * 2^M)이며 같은 값을 찾는 키를 찾는 작업 역시 O(N+2^M)입니다. 이것들을 모두 더하면 O(K * N * (MlogM + 2^M) + 2 * N
     *   * 2^M)이므로 식을 정리하여 O(K * N * MlogM + K * N * 2^M)이겠네요 그러면 최종 가격 시간 복잡도는 O(N * 2^M)으로 쓸 수 있습니다.
     */

    // 만들 수 있는 메뉴 구성과 총 주문 수를 저장할 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public static String[] solution(String[] orders, int[] course) {
        // 해시맵 초기화
        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        // 1. 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        // 2. 모든 코스 후보에 대해서
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o)) // 3. 가장 빈도수가 높은 코스를 찾음
                    .ifPresent(cnt -> count.entrySet() // 4. 코스에 대한매뉴 수가 가능할 때만
                            .stream()
                            // 5. 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            // 6. 코스 메뉴만 answer 리스트에 추가
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer); // 7. 오름차순으로 정렬
        return answer.toArray(new String[0]);
    }

    // 만들 수 있는 몯느 조합을 재귀 함수를 이용해서 구현
    public static void combinations(int idx, char[] order, String result) {
        // 필요한 코스 메뉴의 수와 일치하는지 각난 계정
        if ( courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 해당 코스의 수를 1증가
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}