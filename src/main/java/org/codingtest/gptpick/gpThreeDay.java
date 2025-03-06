package org.codingtest.gptpick;

public class gpThreeDay {

    /*  GPT 코딩 테스트 준비 2일차
    *   - 문제 : 정수 n이 주어졌을 때, n!(팩토리얼)을 재귀 함수를 이용해서 구하는 함수를 작성하라.
    *   - 조건 : 반복문 사용 X(재귀 함수로만 구현)
    *           n == 0 또는 n == 1일 때의 기저 조건을 잘 처리해야 함
    *   - 예제 입력 : n = 5
    *   - 예제 출력 : 120
    */
    public static long recursiveCall(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * recursiveCall(num - 1);
        }
    }
}