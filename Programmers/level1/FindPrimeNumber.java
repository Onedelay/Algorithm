package programmers;

import java.util.ArrayList;

public class FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println(eratos(10));
        System.out.println(eratos(5));
    }

    // 시간초과
    public static int solution(int n) {
        int answer = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) cnt++;
                if (cnt > 2) break;
            }
            if (cnt <= 1) {
                answer++;
            }
            cnt = 0;
        }
        return answer - 1;
    }

    // 에라토스테네스의 체
    // 효율성 테스트에서 실패함(87.5점)
    public static int eratos(int n) {
        int answer = 0;
        ArrayList<Boolean> primeList = new ArrayList<>();

        // 0, 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);

        // 2 ~ n 까지 소수로 처리
        for (int i = 2; i <= n; i++) {
            primeList.add(i, true);
        }

        // 2 부터 i*i <= n 까지. 각각의 배수들 지우기
        for (int i = 2; (i * i) <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * i; j <= n; j += i) {
                    primeList.set(j, false);
                }
            }
        }

        for (int i = 2; i < primeList.size(); i++) {
            if (primeList.get(i)) answer++;
        }
        return answer;
    }

    // http://mygumi.tistory.com/66 참고(백준 소수문제 링크되어있음)
}
