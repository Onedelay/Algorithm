package programmers;

public class Watermelon {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            answer.append(i % 2 == 1 ? "수" : "박");
        }


        return answer.toString();
    }
}
