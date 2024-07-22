package org.codingtest.dynamicprogramming;

public class LCS길이_계산하기 {

    /*  주어진 두 개의 문자열 str1과 str2에 대해 최장 공통 부분 수열의 길이를 계산하는 solution() 함수를 구현하세요.
    *
    *   - 제약 조건
    *   1. 각 문자열 str1과 str2의 길이는 1 이상 1,000 이하입니다.
    *   2. 문자열은 알파벳 대문자, 소문자로만 구성되어 있습니다.
    *
    *   - 시간 복잡도 분석
    *   M과 N은 각각 문자열의 길이입니다. dp 배열의 크기는 M * N 이고 이를 초기화하는데 필요한 시간 복잡도는 O(M * N)입니다. 이후 반복문은
    *   M * N번 수행하므로 시간 복잡도는 O(M * N)입니다.
    */

    public static int solution(String str1, String str2) {
        // 1. 두 문자열의 길이를 저장
        int m = str1.length();
        int n = str2.length();

        // 2. LCS를 저장할 테이블 초기화
        int[][] dp = new int[m + 1][n + 1];

        // 3. 동적 프로그래밍을 통해 LCS 길이 계산
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 4. 현재 비교하는 문자가 같으면
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 5. 현재 비교하는 문자가 같지 않으면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 6. LCS 길이 반환
        return dp[m][n];
    }
}