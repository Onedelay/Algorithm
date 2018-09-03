package programmers;

public class HandleStringBasic {
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
        System.out.println(solution("a2345"));
        System.out.println(solution("123456"));
        System.out.println(solution("12345"));
    }

    static boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)) return false;

        for (char c : s.toCharArray()) {
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }

    // Integer.parseInt 메서드 이용한 방법
    static boolean solution1(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                int x = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) { // 문자가 섞여있다면 Exception 이 발생할 것
                return false;
            }
        } else return false;
    }

    /* 정규표현식을 사용한 방법
     * matches : 정규식을 이용하여 문자열을 검색한다.
     * 특정 문자열을 검색할때 사용하기 보다는 한글, 숫자 등과 같이 해당 형태의 텍스트가 존재하는지 확인할때 사용하면 좋다. */
    static boolean solution2(String s) {
        /* 정규표현식 정리
         * () : () 안의 내용을 하나의 묶음으로 사용함을 의미
         * ^ : 문자열의 시작을 의미
         * [0-9] : 0~9 까지의 숫자
         * * : 바로 앞에 문자가 없거나, 하나 이상 반복 의미
         * $ : 문자열의 끝을 의미
         */
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
    }
}
