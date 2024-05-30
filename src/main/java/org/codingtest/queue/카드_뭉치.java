package org.codingtest.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 카드_뭉치 {

    /*  코니는 영어 단어가 적힌 카드 뭉치 2개를 선물로 받았습니다. 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의
    *   단어 배열을 만들 수 있는지 알고 싶습니다.
    *     * 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
    *     * 한 번 사용한 카드는 다시 사용할 수 없습니다.
    *     * 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
    *     * 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
    *   예를 들어 첫 번째 카드 뭉치에["i", "drink", "water"], 두 번째 카드 뭉치에["want", "to"]가 적혀있을 때
    *   ["i", "want", "to", "drink", "water"]순서의 단어 배열을 만들려고 합니다. 첫 번째 카드 뭉치에서 "i"를 사용한 후 두번째 카드
    *   뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고 첫 번째 카드 뭉치에 "drink"와 "water"를 차례대로 사용하면
    *   원하는 순서의 단어 배열을 만들 수 있습니다. 문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때
    *   card1과 card2에 적힌 단어들로 goal를 만들 수 있다면 "Yes"를, 만들 수 없다면 "No"를 반환하는 solution() 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. 1 <= cards1의 길이, cards2의 길이 <= 10
    *     * 1 <= cards1[i]의 길이, cards2[i]의 길이 <= 10
    *     * cards1과 cards2에는 서로 다른 단어만 있음
    *   2. 2 <= goal의 길이 <= cards1의 길이 + cards2의 길이
    *     * 1 <= goal[i]의 길이 <= 10
    *     * goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있음
    *   3. cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있음
    *
    *   - 시간 복잡도 분석
    *   cards1과 cards2의 길이는 N이고, goal의 길이는 M입니다. 이를 각각 deque로 변환하기 위한 시간 복잡도는 O(N + M)이고 반복문에서
    *   goal의 각 원소를 순회하는 시간 복잡도는 O(M)입니다. 따라서 최종 시간 복잡도는 O(N + M)입니다.
    */
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards와 goal를 deque로 전환
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        // 1. goalDeque에 문자열이 남아 있으면 계속 반복
        while (!goalDeque.isEmpty()) {
            // 2. cardsDeque1의 front와 일치하는 경우
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque1.pollFirst();
                goalDeque.pollFirst();
            } else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                // 3. cardsDeque2의 front와 일치하는 경우
                cardsDeque2.pollFirst();
                goalDeque.pollFirst();
            } else {
                break; // 일치하는 원소를 찾지 못했으므로 종료
            }
        }

        // 4. goal이 비었으면 "Yes" 아니면 "No"를 반환
        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}