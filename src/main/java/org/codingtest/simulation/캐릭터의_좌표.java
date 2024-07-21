package org.codingtest.simulation;

import java.util.HashMap;

public class 캐릭터의_좌표 {

    /*  머쓱이는 RPG게임을 하고 있습니다. 게임에는 up, down, left, right 방향키가 있으며 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한
     *  칸씩 이동합니다. 예를 들어 [0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1], down을 누른다면 [0, -1], left를 누른다면 [-1, 0],
     *  right를 누른다면 [1, 0]입니다. 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다.
     *  캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 return하도록 solution 함수를 완성해주세요.
     *  [0, 0]은 board의 정 중앙에 위치합니다. 예를 들어 board의 가로 크기가 9라면 캐릭터는 왼쪽으로 최대 [-4, 0]까지
     *  오른쪽으로 최대 [4, 0]까지 이동할 수 있습니다.
     *
     *   - 제약 조건
     *   1. board은 [가로 크기, 세로 크기] 형태로 주어집니다.
     *   2. board의 가로 크기와 세로 크기는 홀수입니다.
     *   3. board의 크기를 벗어난 방향키 입력은 무시합니다.
     *   4. 0 ≤ keyinput의 길이 ≤ 50
     *   5. 1 ≤ board[0] ≤ 99
     *   6. 1 ≤ board[1] ≤ 99
     *   7. keyinput은 항상 up, down, left, right만 주어집니다.
     *
     *   - 시간 복잡도 분석
     *   N은 입력으로 주어진 숫자입니다. N을 이진수로 변환할 때 시간 복잡도는 O(logN)입니다. 변환된 문자열의 길이는 최대 logN이므로
     *   문자열에서 "1"을 셀 때의 시간 복잡도는 O(logN)입니다. 따라서 최종 시간 복잡도는 O(logN)입니다.
     */

    private static int width, height;
    // 1. 보드의 경계 좌표를 벗어나는지 확인하는 메서드
    private static boolean isInBounds(int x, int y, int dx, int dy){
        return Math.abs(x + dx) <= width && Math.abs(y + dy) <= height;
    }

    public static int[] solution(String[] keyinput, int[] board) {
        // 2. 캐릭터의 초기 위치
        int x = 0, y = 0;
        // 3. 각 방향에 대한 움직임
        HashMap<String, int[]> moves = new HashMap<>();
        moves.put("up", new int[]{0, 1});
        moves.put("down", new int[]{0, -1});
        moves.put("left", new int[]{-1, 0});
        moves.put("right", new int[]{1, 0});
        // 4. 게임 경계 좌표
        width = board[0] / 2;
        height = board[1] / 2;

        for (String key : keyinput) {
            int dx = moves.get(key)[0];
            int dy = moves.get(key)[1];
            // 6. 게임 맵의 크기를 벗어나지 않는지 확인
            if (isInBounds(x, y, dx, dy)) {
                x += dx;
                y += dy;
            }
        }
        // 7. 캐릭터의 위치를 반환합니다.
        return new int[]{x, y};
    }

}