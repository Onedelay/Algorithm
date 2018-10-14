package programmers.level1;

import java.util.Arrays;

// 레벨 1 : 체육복
public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌옷을 도둑맞아서 빌려줄 수 없는 경우 (본인은 입을 수 있으니 lost size 에서 빼도록 answer++)
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == 0) continue; // 이미 여벌옷을 빌려줌
                if (Math.abs(lost[i] - reserve[j]) == 1) { // 옆사람이면 빌려줌
                    answer++;
                    reserve[j] = 0;
                    break;
                }
            }
        }

        return n - lost.length + answer; // 전체 인원수 - 도둑맞은 수 - 옷을 빌린사람
    }
}
