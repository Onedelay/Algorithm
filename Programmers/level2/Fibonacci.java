package programmers.level2;

// 레벨 2 피보나치 수
public class Fibonacci {
    private static int[] fibomem = new int[100001];

    public static void main(String[] args) {
        System.out.println(solution(100));
    }

    // Top-down(재귀) 방식으로 시간초과가 난다면 Bottom-up 방식(반복문)으로 변경하자
    // 음수가 나오는 경우는 오버플로우가 발생했음을 인지하자
    public static int solution(int n) {
        fibomem[1] = 1;
        fibomem[2] = 2;
        for (int i = 3; i <= n; i++) {
            fibomem[i] = (fibomem[i - 1] + fibomem[i - 2]) % 1234567;
        }
        return fibomem[n];
    }
}
