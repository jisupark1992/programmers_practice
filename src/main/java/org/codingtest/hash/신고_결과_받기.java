package org.codingtest.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고_결과_받기 {

    /*
     *   신고_결과_받기
     *   이미지 필요 : https://school.programmers.co.kr/learn/courses/30/lessons/92334
     *
     *   - 제약 조건
     *   1. 2 ≤ id_list의 길이 ≤ 1,000
     *      * 1 ≤ id_list의 원소 길이 ≤ 10
     *      * id_list의 원소는 이용자의 id를 나타내는 문자열이며 알파벳 소문자로만 이루어져 있습니다.
     *      * id_list에는 같은 아이디가 중복해서 들어있지 않습니다.
     *   2. 1 ≤ report의 길이 ≤ 200,000
     *      * 3 ≤ report의 원소 길이 ≤ 21
     *      * report의 원소는 "이용자id 신고한id"형태의 문자열입니다.
     *      * 예를 들어 "muzi frodo"의 경우 "muzi"가 "frodo"를 신고했다는 의미입니다.
     *      * id는 알파벳 소문자로만 이루어져 있습니다.
     *      * 이용자id와 신고한id는 공백(스페이스)하나로 구분되어 있습니다.
     *      * 자기 자신을 신고하는 경우는 없습니다.
     *   3. 1 ≤ k ≤ 200, k는 자연수입니다.
     *   4. return 하는 배열은 id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.
     */
    public static int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String, Integer> count = new HashMap<>();

        // 1. 신고 기록 조회
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if(!reportedUser.containsKey(reportedId)) {// 2. 신고당한 기록이 없다면
                reportedUser.put(reportedId, new HashSet<>());
            }

            // 3. 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) { // 4. 정지 기준에 만족하는지 확인
                for (String uid : entry.getValue()) {// 5. 해시셋을 순회하며 count 계산
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        // 6. 각 아이디별 메일을 받은 횟수를 순서대로 정리
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}