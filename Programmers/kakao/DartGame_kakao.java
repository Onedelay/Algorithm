package programmers.kakao;

public class DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    static boolean isAlpha(char c) {
        return c >= 68 && c <= 84;
    }

    static boolean isBonus(char c) {
        return c >= 35 && c <= 42;
    }

    static int solution(String dartResult) {
        int answer = 0;
        int pv = 0, cv = 0;
        char[] array = dartResult.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : array) {
            if (!isAlpha(c) && !isBonus(c)) {
                builder.append(c);
            } else if (isBonus(c)) {
                if (c == '*') {
                    answer += cv + pv;
                    cv *= 2;
                } else {
                    answer += -2 * cv;
                    cv *= -1;
                }
            } else {
                pv = cv;
                cv = Integer.parseInt(builder.toString());
                builder = new StringBuilder();

                if (c == 'D') {
                    cv = (int) Math.pow(cv, 2);
                } else if (c == 'T') {
                    cv = (int) Math.pow(cv, 3);
                }
                answer += cv;
            }
        }

        return answer;
    }
}
