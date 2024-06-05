package org.codingtest.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class 베스트_앨범 {

    /*  스트리밍 사이트에서 장르별로 가장 많이 재생된 노래를 2개씩 모아 베스트 앨범을 출시하려합니다. 노래는 고유 번호로 구분하며, 노래 수록 기준은
    *   다음과 같습니다.
    *       * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    *       * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    *       * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    *   노래의 장르를 나타내는 문자열 배열 genres와 노래별재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유
    *   번호를 순서대로 반환하는 solution() 함수를 완성하세요.
    *
    *   - 제약 조건
    *   1. genres[i]는 고유 번호가 i인 노래 장르입니다.
    *   2. plays[i]는 고유 번호가 i인 노래가 재생된 횟수입니다.
    *   3. genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    *   4. 장르 종류는 100가지 미만입니다.
    *   5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    *   6. 모든 장르는 재생된 횟수가 다릅니다.
    *
    *   - 시간 복잡도 분석
    *   N은 play와 genres의 길이이고, G는 장르의 수입니다. 각 노래의 장르와 재생 횟수를 해시맵에 저장하는 시간 복잡도는 O(N)입니다. 이때
    *   장르별 총 재생 횟수를 기준으로 정렬하기 위한 시간 복잡도는 O(GlogG)이지만 G는 최대 100이므로 이는 상수로 고려하고 무시합니다.
    *   그다음 각 장르 내에서 노래를 재생 횟수 순으로 정렬하기 위한 시간 복잡도는 O(NlogN)이므로 최종 시간 복잡도는 O(NlogN)입니다.
    */
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        // 1. 장르별 총 재생 횟수와 각 곡의 재생 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // 2. 총 재생 횟수가 많은 장르순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        // 3. 각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream().sorted((o1, o2) -> Integer.compare(o2[1], o1[1])).limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}