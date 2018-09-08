package programmers.level2;

// 레벨 2 : 숫자의 표현
public class RepresentOfNum {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum += j;
				if (sum > n) {
                    break;
                }
                else if (sum == n) {
                    answer++;
                    break;
                }
            }
            sum = 0;
        }
        return answer;
    }
}
