package programmers.level2;

// 레벨 2 다음 큰 숫자
public class NextBigNum {
    public static void main(String[] args) {
        System.out.println(solution(11));
    }

    public static int solution(int n) {
        int answer = 0, pcount = 0, count = 0;
        char[] bit = Integer.toBinaryString(n).toCharArray();
        for (char c : bit) {
            if (c == '1') pcount++;
        }

        for (int i = n + 1; i < n << 1; i++) {
            bit = Integer.toBinaryString(i).toCharArray();
            for (char c : bit) {
                if (c == '1') count++;
            }
            if (count == pcount) {
                return i;
            }
            count = 0;
        }

        return answer;
    }

    // 더 편한 메서드
    public static int solution1(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        for (int i = n + 1; i < n << 1; i++) {
            if (Integer.bitCount(i) == count){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
