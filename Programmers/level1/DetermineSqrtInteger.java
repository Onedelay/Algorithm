package programmers.level1;

public class DetermineSqrtInteger {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static long solution(long n) {
        for (long i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return (i + 1) * (i + 1);
            }
        }
        return -1;
    }
}
