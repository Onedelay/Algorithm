package programmers.level2;

public class P12899 {
    public static void main(String[] args) {
        System.out.println(solution(30));
        System.out.println(solution(27));
        System.out.println(solution(13));
        System.out.println(solution(15));
        System.out.println(solution(18));
    }

    public static String solution(long n) {
        StringBuilder answer = new StringBuilder();
        long tmp;
        while (n >= 1) {
            tmp = n % 3;
            n = (n - 1) / 3;
            switch ((int) tmp) {
                case 1:
                    answer.append(1);
                    break;
                case 2:
                    answer.append(2);
                    break;
                case 0:
                    answer.append(4);
                    break;
            }
        }

        return answer.reverse().toString();
    }
}
