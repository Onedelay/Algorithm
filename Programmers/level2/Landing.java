package programmers.level2;

// 레벨 2 땅따먹기
public class Landing {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 10},
                {1, 2, 3, 4}};
        int[][] arr2 = {
                {5, 4, 3, 2},
                {5, 4, 3, 2},
                {5, 4, 3, 2},
                {5, 4, 3, 2}};
        int[][] arr3 = {
                {5, 2, 3, 1},
                {10, 6, 7, 9},
                {1, 1, 1, 1},
                {1, 2, 3, 4}};
        System.out.println(solution(arr1));
    }

    // 오답
    static int solution_(int[][] land) {
        int answer = 0;
        int max = 0;
        int index = -1;     // 현재 최대값 인덱스
        int pindex = -2;    // 이전 최대값 인덱스
        for (int[] aLand : land) {
            for (int j = 0; j < 4; j++) {
                if (j != pindex && aLand[j] > max) { // 이전 최대값 인덱스와 같으면 pass
                    max = aLand[j]; // 최대값 갱신
                    index = j;      // 현재 최대값 인덱스 저장
                }
            }

            pindex = index; // 이전 최대 인덱스 <- 현재 최대 인덱스로 갱신
            System.out.println(String.format("index = %d / max = %d", index, max));
            answer += max;
            max = 0;
        }

        return answer;
    }

    // DP
    static int solution(int[][] land) {
        int max = 0;
        for (int i = 1; i < land.length; i++) { // 행
            for (int j = 0; j < 4; j++) {     // 현재 값 인덱스
                for (int k = 0; k < 4; k++) { // 최대값 찾기 인덱스
                    if (land[i - 1][k] > max && j != k) { // j 와 k 가 같으면 연속된 열이므로 pass
                        max = land[i - 1][k];             // 이전 행에서 가장 큰 값 찾기
                    }
                }
                land[i][j] += max;                      // 현재 행에 이전행 중 가장 큰 값 더함
                max = 0;
            } // 다음 행으로 이동
        }

        max = 0;
        for (int i = 0; i < 4; i++) {
            if (land[land.length - 1][i] > max) max = land[land.length - 1][i];
        }
        return max;
    }
}
