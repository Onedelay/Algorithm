package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 레벨 2 최솟값 만들기
public class CreateMinimum {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        System.out.println(solution(A,B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        // 오름차순, 내림차순으로 정렬
        for (int i = 0; i < A.length; i++) {
            aList.add(A[i]);
            bList.add(B[i]);
        }

        aList.sort(Comparator.comparingInt(o -> o));
        bList.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < aList.size(); i++) {
            answer += aList.get(i) * bList.get(i);
        }

        return answer;
    }

    // 더 나은 방법
    public static int solution1(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }
}
