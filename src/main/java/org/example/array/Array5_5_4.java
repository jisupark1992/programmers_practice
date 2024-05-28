package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Array5_5_4 {

    /*  수포자는 수학을 포기한 사람을 줄인 표현입니다. 수포자가 삼인방은 모의고사에 수학문제를 전부
    *   찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
    *
    *   * 1번 수포자가 찍는 방식 : 1, 2, 3, 4, 5,...
    *   * 2번 수포자가 찍는 방식 : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4,...
    *   * 3번 수포자가 찍는 방식 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 1, 1, 2, 2,...
    *
    *   1번 문제부터 마지막 문제까지의 정답이 순서대로 저장된 배열 answers가 주어졌을 때 가장 많은 문제를
    *   맞힌 사람이 누구인지 배열에 담아 반환하도록 solution() 함수를 작성하세요.
    *
    *   - 제약 조건
    *   1. 시험은 최대 10,000 문제로 구성되어 있습니다.
    *   2. 문제의 정답은 1, 2, 3, 4, 5 중 하나입니다.
    *   3. 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬하세요.
    */

    public static int[] solution(int[] answers) {
        int[] clone = answers.clone();

        // 1. 수포자들의 패턴
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,}
        };

        // 2. 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 3. 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인
        for(int i = 0; i < clone.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        // 4. 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();
        // 5. 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}