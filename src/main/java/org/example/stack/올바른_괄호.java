package org.example.stack;

import java.util.ArrayDeque;

public class 올바른_괄호 {

    /*  괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
    *   1. "()()" 또는 "(())()"는 올바른 괄호입니다.
    *   2. ")()(" 또는 "(()("는 올바르지 않은 괄호입니다.
    *   '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 반환하고
    *   올바르지 않은 괄호면 false를 반환하는 solution() 함수를 완성해주세요.
    *
    *   - 제약 조건
    *   1. 문자열 s의 길이 : 100,000 이하의 자연수
    *   2. 문자열 s는 '('또는 ')'로만 이루어져 있습니다.
    *
    *   - 시간 복잡도 분석
    *   N은 s의 길이이고 s를 순회하며 괄호의 쌍을 확인하므로 시간 복잡도는 O(N)입니다.
    *   참고로 괄호 쌍을 확인할 때 push()와 pop()메서드의 시간 복잡도는 O(1)입니다.
    */

    public static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                // 스텍이 비어있는거 먼저 확인하고 pop을 한다. 만약 스택이 비어있을때 pop한다면 EmptyStackException 발생
                if (stack.isEmpty() || stack.pop() == c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}