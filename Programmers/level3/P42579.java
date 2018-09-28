package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;

// 레벨 3 : 베스트앨범
public class P42579 {
    class Music {
        int id;
        String genre;
        int plays;

        public Music(int id, String genre, int plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        HashMap<String, Integer> map = new HashMap<>();

        ArrayList<Music> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) map.put(genres[i], plays[i]);
            else map.put(genres[i], map.get(genres[i]) + plays[i]);
            list.add(new Music(i, genres[i], plays[i]));
        }

        list.sort((o1, o2) -> {
            if (o1.genre.equals(o2.genre)) { // 장르가 같다면 재생수 기준 내림차순
                return o2.plays - o1.plays;
            } else {
                return map.get(o2.genre) - map.get(o1.genre); // 장르가 다르면 총 재생수 기준 내림차순
            }
        });

        // 총 재생수 기준으로 장르 순서, 장르별 재생수는 내림차순으로 정렬 완료

        ArrayList<Music> result = new ArrayList<>();

        int count = 0;      // 2개에서 cut
        String prev = null; // 이전 장르
        for (Music m : list) {
            if (m.genre.equals(prev)) {
                if (count != 2) {
                    result.add(m);
                    count++;
                }
            } else {
                count = 1;
                result.add(m);
            }
            prev = m.genre;
        }

        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).id;
        }

        return answer;
    }
}
