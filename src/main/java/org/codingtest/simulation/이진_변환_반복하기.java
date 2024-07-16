package org.codingtest.simulation;

public class 이진_변환_반복하기 {

    /*  0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
     *      1. x의 모든 0을 제거합니다.
     *      2. x의 길이를 c라고 하면 x를 'c를 2진법으로 표현한 문자열'로 바꿉니다.
     *  예를 들어 x = "0111010"이면 이진 변환 과정은 "0111010" -> "1111" -> "100"입니다. 0과 1로 이루어진 문자열 s가 주어지고 s가
     *  "1"이 될 때까지 계속해서 이진 변환을 할 때 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 배열에 담아 반환하는 solution() 함수를
     *  완성해주세요.
     *
     *   - 제약 조건
     *   1. s의 길이는 1이상 150,000 이하입니다.
     *   2. s에는 '1'이 하나 이상 포함되어 있습니다.
     *
     *   - 시간 복잡도 분석
     *   N은 주어진 수입니다. while문에서 N이 1이 될 때까지 2로 나누므로 시간 복잡도는 O(logN)입니다. 그리고 s.replace()를 호출할 때
     *   필요한 시간 복잡도는 O(N)입니다. 따라서 최종 시간 복잡도는 O(NlogN)입니다.
     */

    public static int[] solution(String s) {
        // 1. 이진 변환 횟수를 저장하는 변수
        int countTransform = 0;
        // 2. 제거된 모든 0의 개수를 저장하는 변수
        int countZero = 0;

        // 3. s가 '1'이 아닌 동안 계속 반복
        while (!s.equals("1")) {
            // 4. 이진 변환 횟수를 1 증가
            countTransform++;
            // 5. s에서 '0'의 개수를 세어 countZero에 누적
            int zero = s.replace("1", "").length();
            countZero += zero;
            // 6. s에서 '1'의 개수를 세고, 이를 이진수로 반환
            // Integer.toBinaryString() 메서드를 활용
            s = Integer.toBinaryString(s.length() - zero);
        }
        // 7. 이진 변환 횟수와 제거된 모든 '0'의 개수를 배열에 담아 반환
        return new int[]{countTransform, countZero};
    }
}