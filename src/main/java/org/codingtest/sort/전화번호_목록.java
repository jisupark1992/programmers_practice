package org.codingtest.sort;

import java.util.Arrays;

public class 전화번호_목록 {

    /*
    *   전화번호부에 적힌 전화번호 중 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다. 전화번호가 다음과 같을 경우 구조대
    *   전화번호는 영석이 전화번호 접두사입니다.
    *       * 구조대 : 119
    *       * 박준영 : 97 674 223
    *       * 지영석 : 11 9552 4421
    *   전화번호부에 적힌 전화번호를 담은 배열 phone_book이 solution() 함수의 매개변수로 주어 질 때 어떤 번호가 다른 번호의 접두어이면
    *   false, 그렇지 않으면 true를 반환하는 solution() 함수를 작성해주세요.
    *
    *   - 제약 조건
    *   1. phone_book의 길이는 1 이상 1,000,000 이하입니다.
    *       * 각 전화번호의 길이는 1 이상 20 이하입니다
    *       * 같은 전화번호가 중복해서 들어 있지 않습니다.
    *
    *   - 시간 복잡도
    *   N은 phone_book의 길이입니다. phone_book을 정렬하는 시간 복잡도는 O(NlogN)입니다. 다음으로 phone_book의 길이만큼 반복문을
    *   순회하고 내부에 있는 startwith() 메서드는 문자열의 길이에 비례하는 연산을 수행합니다. 문자열 길이는 20이므로 상수 처리합니다.
    *   따라서 최종 시간 복잡도는 O(NlogN) + O(N)으로 O(NlogN)입니다.
    */

    public static boolean solution(String[] phone_book) {
        // 1. 전화번호부 발행
        Arrays.sort(phone_book);
        // 2. 전화번호부에서 연속된 두 개의 전화번호 비교
        for (int i = 0 ; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // 3. 모든 전화번호를 비교한 후에도 반환되지 않았다면, 접두어가 없는 경우이므로 true 반환
        return true;
    }
}