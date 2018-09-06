package programmers.level1;

public class GcdLcm {
    public static void main(String[] args) {
        for (int i=0; i<2; i++) {
            System.out.println(solution(3, 12)[i]);
        }
    }

    static int gcd(int m, int n) {
        int temp, r;
        if (n > m) {
            temp = n;
            n = m;
            m = temp;
        }
        while (n != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    static int lcm(int m, int n) {
        int a = m, b = n;
        while (a != b) {
            if (a < b) {
                a += m;
            } else {
                b += n;
            }
        }
        return a;
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        return answer;
    }
}
