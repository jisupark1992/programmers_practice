package org.example.stack;

import java.util.ArrayDeque;
import java.util.HashMap;

public class 괄호_회전하기 {

    /*  다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
    *   1. "()", "[]", "{}"는 모두 올바른 괄호 문자열입니다.
    *   2. 만약 A가 올바른 괄호 문자열이라면, "(A)", "[A]", "{A}"도 올바른 괄호 문자열입니다. 예를 들어
    *      "[]"가 올바른 괄호 문자열이므로, "([])"도 올바른 괄호 문자입니다.
    *   3. 만약 A, B가 올바른 괄호 문자열이라면, AB도 올바른 괄호 문자열입니다. 예를 들어 "()"와 "([])"가
    *      올바른 괄호 문자열이므로, "{}([])"도 올바른 괄호 문자열입니다.
    *   대괄호, 중괄호 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x(0 <= x < (s의 길이))
    *   칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 반환하는 solution() 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. s의 길이는 1 이상 1,000 이하입니다.
    *
    *   - 시간 복잡도 분석
    *   N의 s의 길이입니다. 회전한 괄호 문자열의 유효성을 체크할 때 이중 반복문을 활용하므로 시간 복잡도는 O(N^2)입니다.
    *   참고로 괄호 쌍을 확인할 때 push() 메서드와 pop() 메서드의 시간 복잡도는 O(1)입니다.
    */
    public static int solution(String s) {
        // 1. 괄호 정보를 저장함, 코드를, 간결하게 할 수 있음
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length(); // 원본 문자열의 길이 저장
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌
        int answer = 0;

        // 2. 확인할 문자열의 시작 인덱스를 0부터 n까지 이동
        A : for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // 3. i(시작 위치)부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                // 해시맵 안에 해당 키가 없다면 열리는 괄호
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 4. 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            // 5. 3에서 continue 되지 않았고, 스텍이 비어있으면 올바른 괄호 문자열임
            if(stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}