package programmers;

public class CaesarPassword {
    public static void main(String[] args) {
        System.out.println(solution("AB", 3));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
        System.out.println(solution("XYZ", 4));
        System.out.println(solution("zZ", 1));

        System.out.println(solution("A", 25));
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                if (c >= 'A' && c <= 'Z') {
                    if (c + n > 'Z') {
                        answer.append((char) (((c + n) % 'Z') + 64));
                    } else {
                        answer.append((char) (c + n));
                    }
                } else {
                    if (c + n > 'z') {
                        answer.append((char) (((c + n) % 'z') + 96));
                    } else {
                        answer.append((char) (c + n));
                    }
                }
            } else {
                answer.append(' ');
            }
        }

        return answer.toString();
    }

    // 간소화된 버전
    public static String solution1(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            answer.append(ch);
        }

        return answer.toString();
    }
}
