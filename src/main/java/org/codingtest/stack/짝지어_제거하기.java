package org.codingtest.stack;

import java.util.Stack;

public class 짝지어_제거하기 {

    /*  짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
    *   그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
    *   문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요.
    *   성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다. 예를 들어, 문자열 S = "baabaa" 라면 b aa baa -> bb aa -> aa
    *   의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
    *
    *   - 제약 조건
    *   1. 문자열의 길이 : 1,000,000이하의 자연수
    *   2. 문자열은 모두 소문자로 이루어져 있습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 s의 길이입니다. 문자열의 모든 문자를 한 번씩 순회하므로 시간 복잡도는 O(N)입니다.
    */
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1. 스택이 비어 있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 2. 스택의 맨 위 문자 제거
            } else {
                stack.push(c); // 3. 스텍에 현재 문자 추가
            }
        }

        return stack.isEmpty() ? 1 : 0; // 4. 스텍이 비어 있으면 1, 그렇지 않으면 0 반환
    }
}