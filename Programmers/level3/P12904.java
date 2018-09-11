package programmers.level3;

// 레벨 3 : 가장 긴 팰린드롬
public class P12904 {
    public static void main(String[] args) {
        System.out.println(solution3("abcdcba")); // 7
        System.out.println(solution3("aaaaabaaaaaaaa")); // 11
        System.out.println(solution3("aaabbbb")); // 4
        System.out.println(solution3("abacde")); // 3
        System.out.println(solution3("abddadda"));
        System.out.println(solution3("zzabazz"));
        System.out.println(solution3("zxabazx"));

    }

    public static int solution3(String s) {
        int answer = 1, cnt = 0;
        StringBuilder sb = new StringBuilder();

        // 짝수개일 경우 대비
        for (int i = 0; i < s.length(); i++) {
            sb.append("@");
            sb.append(s.charAt(i));
        }
        sb.append("@");

        s = sb.toString();
        System.out.println(s);

        // 현재 위치(i)부터 양방향으로 확인.
        // i-1, i+1 위치 문자가 서로 다르면 팰린드롬 아님
        // 골뱅이가 껴있어서 * 2 + 1 한 효과! (카운트는 한쪽방향만 세기 때문에)
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < s.length()-i; j++) {
                if (i - j >= 0 && i + j < s.length()) {
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        System.out.println(String.format("%c / %c / %c", s.charAt(i - j), s.charAt(i), s.charAt(i + j)));
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
            if (cnt > answer) {
                answer = cnt;
            }
            cnt = 0;
        }

        return answer;
    }

    // "aaabbbb 안됨"
    public static int solution2(String s) {
        int answer = 1, len;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String reverse = sb.reverse().toString();
        sb = new StringBuilder();
        char start;
        for (int i = 0; i < s.length(); i++) {
            start = s.charAt(i);
            sb.append(start);
            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                if (s.charAt(j) == start) {
                    len = sb.toString().length();
                    if (reverse.contains(sb.toString())) {
                        if (len > answer) answer = len;
                    }
                }
            }
            sb = new StringBuilder();
        }

        return answer;
    }

    // 시간초과
    public static int solution1(String s) {
        int answer = 1, len;
        StringBuilder sb = new StringBuilder();
        String str;

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int j;
            for (j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                str = sb.reverse().toString();
                if (s.substring(i, j + 1).equals(str)) {
                    System.out.println(String.format("i:%d j:%d,%s --- %s", i, j, s.substring(i, j + 1), sb.reverse().toString()));
                    len = sb.toString().length();
                    if (len > answer) answer = len;
                    System.out.println(answer);
                }
                sb.reverse();

            }
            sb = new StringBuilder();
            if ((s.length() - i - 1) * 2 + 1 < answer) break;
        }
        return answer;
    }
}
