package org.codingtest.stack;

import java.util.Arrays;
import java.util.Stack;

public class 표_편집 {

    /*
    *   표 편집
    *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/81303
    *
    *   - 시간 복잡도 분석
    *   N은 표의 행 길이입니다. 초기에 리스트를 초기화할 때 시간 복잡도는 O(N)입니다. 그리고 제약 사항을 보면 명령어 뒤의 X의 모든 합이
    *   100만을 넘지 않는다고 했으므로 명령어를 처리할 때 시간 복잡도는 O(1,000,000)이라고 할 수 있습니다. 그러니 최종 시간 복잡도는 O(N)입니다.
    */
    public static String solution(int n, int k, String[] cmd) {
        // 1. 삭제된 행의 인덱스를 저장하는 스텍
        Stack<Integer> deleted = new Stack<>();
        // 2. 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 3. 현재 위치를 나타내는 인덱스
        k++;

        // 4. 주어진 명령어(cmd) 배열을 하나씩 처리
        for (String c : cmd) {
            // 5. 현재 위치를 삭제하고 그 다음 위치로 이동
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) { // 6. 가장 최근에 삭제된 행을 복원
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else { // 7. U 또는 D를 사용해 현재 위치를 위, 아래로 이동
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        // 8. 삭제된 행의 위치에 'X'를, 그렇지 않은 행 위치에는 '0'를 저장한 문자열 반환
        char[] answer = new char[n];
        Arrays.fill(answer, '0');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}