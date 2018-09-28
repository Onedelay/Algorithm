package programmers.level2;

import java.util.LinkedHashMap;

// 레벨 2 : 기능개발
public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                cnt++;
            }

            progresses[i] = cnt;

            // 앞서 배포될 기능(i-1)보다 현재 배포될 기능일수(i)가 작을 경우 함께 배포
            if (i >= 1 && progresses[i - 1] > progresses[i]) progresses[i] = progresses[i - 1];
        }

        // 그냥 HashMap 을 사용할 경우 순서가 뒤바뀌어서 나올 수 있음
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i : progresses) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }

        answer = new int[map.size()];
        int idx = 0;
        for (int i : map.values()) {
            answer[idx++] = i;
        }

        return answer;
    }
}
