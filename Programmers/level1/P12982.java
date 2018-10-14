package programmers.level1;

import java.util.Arrays;

// 레벨 1 : 예산
public class P12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int index = 0;
        while (budget > 0 && index < d.length) {
            if (budget - d[index] >= 0) {
                budget -= d[index++];
                answer++;
            } else break;
        }

        return answer;
    }
}
