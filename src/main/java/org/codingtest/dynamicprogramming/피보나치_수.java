package org.codingtest.dynamicprogramming;

public class 피보나치_수 {

    /*  2 이상의 n이 입력되었을 때 n번째 피보나치 수를 1234567로 나눈 나머지를 반환하는 solution()함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. n은 2 이상 100,000 이하인 자연수입니다.
    *
    *   - 시간 복잡도 분석
    *   N은 피보나치 문제에서 구할 N번째 항입니다. N번째 피보나치 수를 구할 때까지 반복문은 N번 수행하므로 시간 복잡도는 O(N)입니다.
    */

    public static int solution(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }
        return fibo[n];
    }
}