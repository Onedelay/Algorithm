package programmers.etc;

// 알고리즘 강의 : 스티커 모으기
public class P1881 {
    public int solution(int sticker[]) {
        int size = sticker.length;

        if (size < 2) return sticker[0];

        int[] dp1 = new int[size];
        int[] dp2 = new int[size];

        // 첫번째 스티커를 뜯은 경우
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < size - 1; i++) {
            dp1[i] = dp1[i - 1] > dp1[i - 2] + sticker[i] ? dp1[i - 1] : dp1[i - 2] + sticker[i];
        }

        // 뜯지 않은 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < size; i++) {
            dp2[i] = dp2[i - 1] > dp2[i - 2] + sticker[i] ? dp2[i - 1] : dp2[i - 2] + sticker[i];
        }

        return dp1[size - 2] > dp2[size - 1] ? dp1[size - 2] : dp2[size - 1];
    }
}
