package programmers.level1;

public class HidePhoneNum {
    public static void main(String[] args) {
        System.out.println(solution1("027778888"));
    }

    public static String solution(String phoneNumber) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phoneNumber.length() - 4; i++) {
            answer.append("*");
        }
        return answer.toString() + phoneNumber.substring(phoneNumber.length() - 4, phoneNumber.length());
    }

    // 더 나은 풀이
    public static String solution1(String phoneNumber) {
        char[] chars = phoneNumber.toCharArray();
        for (int i = 0; i < chars.length - 4; i++) {
            chars[i] = '*';
        }
        return String.valueOf(chars);
    }
}
