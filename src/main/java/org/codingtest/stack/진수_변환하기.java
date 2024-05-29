package org.codingtest.stack;

import java.util.Stack;

public class 진수_변환하기 {

    /*  10진수를 입력받아 2진수로 변환해 반환하는 solution() 함수를 구현하세요.
    *
    *   - 제약 조건
    *   1. decimal은 1이상 10억 미만의 자연수
    *
    *   - 시간 복잡도 분석
    *   N은 이진수로 변환할 숫자입니다. N을 이진수로 변환하는 과정은 N이 1이 될 때까지 2로 계속 나누므로
    *   연산 횟수는 O(logN)입니다. String의 +연산자는 수행할 때마다 객체를 새로 생성합니다. 따라서 문자열의
    *   길이가 게속 길어지는 반복문 내에서는 가급적 String의 +연산보다는 StringBuilder를 사용하는 것이 바람직합니다.
    *   StringBuilder를 사용한 코드의 시간 복잡도는 O(logN)입니다. 만약 String +연산을 사용한다면 O(logN^2)이 됩니다.
    */
    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // String의 + 연산은 시간 복잡도 측면에서 성능이 좋지 않음
        // 따라서 StringBuilder를 사용
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}