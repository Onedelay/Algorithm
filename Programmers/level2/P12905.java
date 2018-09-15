package programmers.level2;

public class P12905 {
    public static void main(String[] args) {
        int[][] board1 = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board2 = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        int[][] board3 = {{0, 0, 0, 1}, {0, 0, 0, 0}};

        System.out.println(solution(board1));
        System.out.println(solution(board2));
        System.out.println(solution(board3));
    }

    public static int min(int a, int b, int c) {
        int min = 1001;
        if (a < min) {
            min = a;
        }
        if (b < min) {
            min = b;
        }

        if (c < min) {
            min = c;
        }

        return min;
    }

    public static int solution(int[][] board) {
        int answer = 0, sum = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    if (board[i - 1][j - 1] != 0 && board[i - 1][j] != 0 && board[i][j - 1] != 0) {
                        board[i][j] += min(board[i - 1][j - 1], board[i - 1][j], board[i][j - 1]);
                    }
                }
                if (board[i][j] > answer) {
                    answer = board[i][j];
                }
            }
        }

        if (answer == 0) {
            for (int i = 0; i < board[0].length; i++) {
                sum += board[0][i];
            }

            for (int i = 0; i < board.length; i++) {
                sum += board[i][0];
            }

            if (sum != 0) answer = 1;
        }


        return answer * answer;
    }
}
