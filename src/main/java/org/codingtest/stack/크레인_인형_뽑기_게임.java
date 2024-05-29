package org.codingtest.stack;

import java.util.Stack;

public class 크레인_인형_뽑기_게임 {

    /*
    *   크레인 인형 뽑기 게임
    *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/64061
    *
    *   - 제약 조건
    *   1. board는 2차원 배열, 크기는 5 x 5 이상 30 x 30 이하입니다.
    *   2. board는 각 칸에는 0이상 100 이하인 정수가 담겨 있습니다.
    *      * 0은 빈 칸을 나타냅니다.
    *      * 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
    *   3. moves 배열 크기는 1이상 1,000 이하입니다.
    *   4. moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
    *
    *   - 시간 복잡도 분석
    *   N은 board의 행 혹은 열의 길이이고, M은 moves의 길이입니다. board를 순회하는 과정은 O(N^2), moves를 순회하는 과정은 O(M)이므로
    *   시간 복잡도는 O(N^2 + M)입니다. 하지만 N은 최대 30이고 M은 최대 1,000이므로 O(M) 혹은 O(N^2)으로 봐도 문제가 없습니다. 최악의
    *   경우에도 연산 횟수는 대략 30^2 + 1,000이므로 1,900번 정도겠네요. 시간 복잡도가 딱히 의미가 없는 문제입니다.
    */
    public static int solution(int[][] board, int[] moves) {
        // 1. 각 열에 대한 스택을 생성합니다.
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // 2. board를 역순으로 탐색하여, 각 열의 인형을 lanes에 추가합니다.
        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0) {
                    lanes[i].push(board[i][j]);
                }
            }
        }

        // 3. 인형을 담을 bucket을 생성합니다.
        Stack<Integer> bucket = new Stack<>();
        // 4. 사라진 인형의 총 개수를 저장할 변수를 초기화합니다.
        int answer = 0;

        // 5. moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가합니다.
        for (int move : moves) {
            if(!lanes[move - 1].isEmpty()) { // 해당 열에 인형이 있는 경우
                int doll = lanes[move - 1].pop();
                // 6. 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else { // 7. 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }
}