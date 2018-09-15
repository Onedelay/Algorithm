package programmers.level3;

public class P12914 {
    static long[] dp = new long[2001];

    public static void main(String[] args) {

    }

    public long solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
