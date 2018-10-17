package programmers.etc;

// 알고리즘 강의 : 나머지 한 점
public class P1878 {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        // A ^ A ^ B = B
        // A ^ B ^ A = B (다른 나머지 하나 골라내기)
        answer[0] = v[0][0] ^ v[1][0] ^ v[2][0];
        answer[1] = v[0][1] ^ v[1][1] ^ v[2][1];

        return answer;
    }
}
