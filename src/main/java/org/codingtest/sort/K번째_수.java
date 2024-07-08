package org.codingtest.sort;

import java.util.Arrays;

public class K번째_수 {

    /*  배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때 k번째에 있는 수를 구하려 합니다. 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4],
    *   i = 2, j = 5, k = 3이라면
    *   * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
    *   * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
    *   * 2에서 나온 배열의 3번째 숫자는 5입니다.
    *   배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 주어질 때 commands의 모든 원소에 대하여 앞서 설명한 연산을 적용했을 때
    *   나온 결과를 배열에 담아 반환하는 solution() 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. array의 길이는 1이상 100 이하입니다.
    *   2. array의 각 원소는 1이상 100 이하입니다.
    *   3. commands의 길이는 1이상 50 이하입니다.
    *   4. commands의 각 원소는 길이가 3입니다.
    *
    *   - 시간 복잡도 분석
    *   N은 array의 길이, M은 commands의 길이입니다. commands의 각 원소에 대해 배열을 자르는 시간 복잡도는 O(N)이며, 이후 정렬을 포함한
    *   시간 복잡도는 O(NlogN)입니다. 이를 M번 반복하므로 최종 시간 복잡도는 O(M * NlogN)입니다.
    */

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[array.length];

        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            // 1. i번째 부터 j번째까지 자르기
            int[] sliceArr = Arrays.copyOfRange(array, i - 1, j);
            // 2. 자른 배열을 정렬하기
            Arrays.sort(sliceArr);
            // 3. k번째 원소 구하기
            answer[c] = sliceArr[k - 1];
        }
        return answer;
    }
}