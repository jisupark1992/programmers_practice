package org.codingtest.hash;

import java.util.HashMap;

public class 할인_행사 {

    /*  XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다. XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는
    *   행사를 합니다. 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는
    *   날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
    *   예를 들어, 정현이가 원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며, XYZ 마트에서 14일간 회원을 대상으로 할인하는
    *   제품이 날짜 순서대로 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우에 대해 알아봅시다.
    *   첫째 날부터 열흘 간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입을 하지 않습니다. 둘째 날부터 열흘 간에는 바나나를 원하는
    *   만큼 할인구매할 수 없기 때문에 둘째 날에도 회원가입을 하지 않습니다. 셋째 날, 넷째 날, 다섯째 날부터 각각 열흘은 원하는 제품과 수량이
    *   일치하기 때문에 셋 중 하루에 회원가입을 하려 합니다. 정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을
    *   나타내는 정수 배열 number, XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때, 회원등록시 정현이가 원하는
    *   제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하는 solution 함수를 완성하시오. 가능한 날이 없으면 0을 return 합니다.
    *
    *   - 제약 조건
    *   1. 1 <= want의 길이 = number의 길이 <= 10
    *      * 1 <= numbers의 원소 <= 10
    *      * number[i]는 want[i]의 수량
    *      * number의 총합 10
    *   2. 10 <= discount의 길이 <= 100,000
    *   3. want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열
    *      * 1 <= want의 원소의 길이, discount의 원소의 길이 <= 12
    *
    *   - 시간 복잡도 분석
    *   N은 discount 배열의 길이입니다. 주어진 want 배열에 기반하여 10일 동안 할인 상품이 원하는 제품과 일치하는지 확인하므로 시간 복잡도는 O(N)입니다.
    */
    public static int solution(String[] want, int[] number, String[] discount) {
        // 1. want, number배열의 값을 해시맵에 저장
        HashMap<String, Integer> wantMap = new HashMap();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int answer = 0; // 2. 총 일수를 계산할 변수 초기화

        // 3. 측정일 i에 회원가입 시 할인받을 수 있는 품목 체크
        for (int i = 0; i < discount.length - 9; i++) {
            // 4. i일 회원가입 시 할인받는 제품 및 개수를 담을 해시맵
            HashMap<String, Integer> discount10d = new HashMap();

            // 5. i일 회원가입 시 할인받는 제품 및 개수를 해시맵 구성
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }

            // 6. 할인하는 상품의 개수가 원하는 수량과 일치하면 정답 변수에 1 추가
            if (discount10d.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }
}