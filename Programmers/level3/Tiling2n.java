package programmers.level3;

// 레벨 3 : 2xn 타일링
public class Tiling2n {
    static int[] arr = new int[60001];

    public static int tiling(int n) {
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        return arr[n];
    }

    public static int solution(int n) {
        if (n <= 2) return n;
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = (solution(n - 1) + solution(n - 2)) % 1000000007;
        return arr[n];
    }
}
