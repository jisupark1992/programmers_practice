package org.codingtest.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class 기능_개발 {

    /*  프로그레머스팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다. 또 각 기능의 개발
    *   속도는 모두 다르므로 뒤의 기능이 앞의 기능보다 먼저 개발 될 수도 있습니다. 이때, 뒤의 기능은 앞의 기능이 배포될 때 함께 배포되어야
    *   합니다. 배포 순서대로 작업 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다
    *   몇 개의 기능이 배포되는지를 반환하도록 solution() 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. 작업 개수(progresses, speeds의 배열 길이)는 100개 이하입니다.
    *   2. 작업 진도는 100 미만의 자연수입니다.
    *   3. 작업 속도는 100 이하의 자연수입니다.
    *   4. 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에
    *      4%라면 배포는 2일 뒤에 이루어집니다.
    *
    *   - 시간 복잡도 분석
    *   N은 progresses의 길이입니다. daysLeft 배열을 생성하기 위한 시간 복잡도는 O(N), daysLeft의 각 요소를 한 번씩 순회할 때의 시간
    *   복잡도는 O(N)이므로 최종 시간 복잡도는 O(N)입니다.
    */
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;
        // 1. 각 작업의 배포 가능일 계산.
        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0; // 2. 배포될 작업의 수 카운트
        int maxDay = daysLeft[0]; // 3. 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일

        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) { // 4. 배포 가능일이 가장 늦은 배포일보다 빠르면
                count++;
            } else { // 5. 배포 예정일이 기준 배포일보다 느리면
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count); // 6. 마지막으로 카운트된 작업들을 함께 배포
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}