package programmers.level1;

public class NumOfShards {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(12));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        int sumDigit = 0;
        int n = x;
        while (n > 0) {
            sumDigit += n % 10;
            n /= 10;
        }

        return x % sumDigit == 0;
    }

    // 더 나은 방법
    public boolean solution1(int x){
        String[] str = String.valueOf(x).split("");
        int sum = 0;
        for (String s : str) {
            sum += Integer.parseInt(s);
        }

        return x % sum == 0;
    }
}
