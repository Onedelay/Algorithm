package programmers.level2;

import java.util.Arrays;

// 레벨 2 : H index
public class P42747 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int index = 0;

        for (int i = 0; i <= citations[citations.length - 1]; i++) { // i : 인용횟수를 담은 변수, 최대값 까지만 돌아도 됨(더 줄일 수 있음)
            if (citations[index] >= i && i <= citations.length - index) { // 현재 위치 인용횟수가 i번 이상이고, i개 이상 있을 경우
                answer = i;
            } else {
                for (int j = index + 1; j < citations.length; j++) { // 현재 위치 이동(같을 경우 첫번째 위치로)
                    if (citations[index] != citations[j]) {
                        index = j;
                        i--; // i가 증가되었으므로, 원래대로 돌려주고 위 if문 검사
                        break;
                    }
                }
            }
        }

        return answer;
    }

    // 다른 사람의 풀이
    public int solution1(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length - 1; i > -1; i--) { // 맨 뒤에서부터 시작
            int min = Math.min(citations[i], citations.length - i); // 남은 논문 갯수와 현재 인용된 횟수 중 최소값 구함
            if (max < min) max = min;
        }

        return max;
    }

    // 다른 사람의 풀이.. 이게 뭐지?
    public int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) { // 남은 논문 갯수 <= 현재 논문 인용수 일 경우
                answer = citations.length - i; // 남은 논문 갯수
                break;
            }
        }

        return answer;
    }
}
