package programmers.level2;

public class CreateJadenCaseString {
    public static void main(String[] args) {
        System.out.println("3".toLowerCase());
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean sw = true;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == ' ') {
                sw = true;
                answer.append(c);
                continue;
            }
            if (sw) {
                answer.append(String.valueOf(c).toUpperCase());
                sw = false;
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
