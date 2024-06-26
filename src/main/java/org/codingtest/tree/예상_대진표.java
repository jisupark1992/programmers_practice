package org.codingtest.tree;

public class 예상_대진표 {

    /*  게임 대회가 개최되었습니다. 이 대회는 N명이 참가하고 토너먼트 형식으로 진행합니다. N명의 참가자에게 1부터 N번의 번호를 차례대로
    *   배정하고, 1번 <-> 2번, 3번 <-> 4번 ..., N - 1번 <-> N번 번호를 부여한 참가자끼리 게임을 진행합니다. 각 게임에서 이긴 사람은 다음
    *   라운드에 진출합니다. 이 때 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번과 같이 차례로 배정합니다. 만약 1번 <-> 2번끼리
    *   겨루는 게임에서 2번이 승리하면 다음 라운드에서 2번은 1번으로 번호를 부여받습니다. 3번 <-> 4번끼리 겨루는 게임에서 3번이 승리하면
    *   다음 라운드에서 3번은 2번을 부여받습니다. 게임은 최종 한 명이 남을 때까지 진행합니다.
    *   이때 첫 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다. 게임 참가자 수 N,
    *   참가자 번호 A, 경쟁자 번호 B가 함수 solution()의 인수로 주어질 때 첫 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와
    *   몇 번째 라운드에서 만나는지를 반환하는 solution() 함수를 완성하세요. 단, A번 참가자와 B번 참가자는 서로 만나기 전까지 항상 이긴다고
    *   가정합니다.
    *
    *   - 제약 조건
    *   1. N : 2^1 이상 2^20 이하인 자연수(2의 지수로 주어지므로 부전승은 없음)
    *   2. A,B : N 이하인 자연수(N, A != B)
    *
    *   - 시간 복잡도 분석
    *   N은 참가한 인원 수입니다. 같은 번호가 될 때까지 계속해서 2로 나누는 연산을 하므로 시간
    */
    public static int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}