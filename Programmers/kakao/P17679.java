package programmers.kakao;

// 프렌즈 4블록
public class P17679 {
    public static void main(String[] args) {
        String[] strings = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] strings1 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        String[] test = {"TT", "TT"};
        String[] test2 = {"TTT", "TTT"};
        String[] test3 = {"TTA", "ATT"};
        System.out.println(solution(test2.length, test2[0].length(), test2));
        System.out.println(solution(test3.length, test3[0].length(), test3));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] mem; // 사라진 블록 개수 저장

        char[][] boards = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            boards[i] = board[i].toCharArray();
        }

        while (true) {
            int count = 0;
            mem = new int[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = boards[i][j];
                    if (c == boards[i + 1][j] && c == boards[i + 1][j + 1] && c == boards[i][j + 1]) { // 정사각형인지
                        mem[i + 1][j]++;
                        mem[i + 1][j + 1]++;
                        mem[i][j + 1]++;
                        mem[i][j]++;
                        count++;
                    }
                }
            }

            if ((m == 2) && (n == 2)) {
                return count == 1 ? 4 : 0;
            }

            if (count == 0) { // 정사각형이 없으므로 종료
                break;
            }

            // 블록 삭제
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mem[i][j] > 0) boards[i][j] = (char)i;
                }
            }

            // 블록 내리기 (밑에서부터 당기기)
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int i = m - 1; i >= 0; i--) {
                    if (mem[i][j] == 0) {
                        boards[i + cnt][j] = boards[i][j];
                    } else {
                        cnt++;
                    }
                }
                answer += cnt;
            }
        }

        return answer;
    }
}
