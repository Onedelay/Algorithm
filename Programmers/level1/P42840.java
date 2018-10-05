package programmers.level1;

import java.util.ArrayList;

// 레벨 1 : 모의고사
public class P42840 {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] user1 = {1, 2, 3, 4, 5};
        int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int n = answers[i];
            if (n == user1[i % user1.length]) count[0]++;
            if (n == user2[i % user2.length]) count[1]++;
            if (n == user3[i % user3.length]) count[2]++;
        }

        // max 값 찾기
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) list.add(i + 1);
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
