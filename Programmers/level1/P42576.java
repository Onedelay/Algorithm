package programmers.level1;

import java.util.HashMap;

// 레벨 1 : 완주하지 못한 선수
public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String aParticipant : participant) {
            hashMap.merge(aParticipant, 1, (a, b) -> a + b);
        }

        for (String aCompletion : completion) {
            hashMap.put(aCompletion, hashMap.get(aCompletion) - 1);
        }

        for (String aParticipant : participant) {
            if (hashMap.get(aParticipant) > 0) answer = aParticipant;
        }
        return answer;
    }
}
