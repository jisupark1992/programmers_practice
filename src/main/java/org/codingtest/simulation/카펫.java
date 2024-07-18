package org.codingtest.simulation;

public class 카펫 {

    /*  카펫
     *  이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/42842
     *
     *   - 제약 조건
     *   1. 갈색 격자의 수 brown는 8 이상이고 5,000 이하인 자연수입니다.
     *   2. 노란 격자의 수 yellow는 1 이상이고 2,000,000 이하인 자연수입니다.
     *   3. 카펫의 가로 길이는 세로 길이와 같거나 세로 길이보다 깁니다.
     *
     *   - 시간 복잡도 분석
     *   N은 totalSize입니다. 한 변의 최대 길이는 sqrt(N)이므로 최종 시간 복잡도는 O(sqrt(N))입니다.
     */

    public static int[] solution(int brown, int yellow) {
        // 1. 격자의 총 개수 (갈색 격자 + 노란색 격자)
        int totalSize = brown + yellow;
        // 2. 세로 길이의 범위는 3부터 (갈색 격자 + 노란색 격자)의 제곱근
        int sqrt = (int) Math.sqrt(totalSize);
        for (int vertical = 3; vertical <= sqrt; vertical++) {
            // 3. 사각형 구성이 되는지 확인
            if (totalSize % vertical == 0) {
                // 4. 사각형의 가로 길이
                int horizontal = (int)(totalSize / vertical);
                // 5. 카펫 형태로 만들 수 있는지 확인
                if (brown == (horizontal + vertical - 2) * 2) {
                    return new int[]{horizontal, vertical}; // 6. [가로길이, 세로 길이]
                }
            }
        }
        return new int[]{}; // 7. 만약 답을 찾지 못했다면 빈 리스트를 반환
    }
}