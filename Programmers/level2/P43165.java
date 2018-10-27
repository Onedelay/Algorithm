package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P43165 {
    // 삽질의 결과물
//    boolean[][] adjust;
//    boolean[][] visited;
//    int[] temp;
//
//    // 인접행렬 출력 함수
//    void dump(boolean[][] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                if (array[i][j]) System.out.print("1 ");
//                else System.out.print("0 ");
//            }
//            System.out.println();
//        }
//    }
//
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//
//        // +, - 로 배열 바꾸기
//        temp = new int[numbers.length * 2];
//        for (int i = 0; i < temp.length; i++) {
//            if (i % 2 == 0) { // 짝수일 경우 그대로
//                temp[i] = numbers[i % numbers.length];
//            } else {
//                temp[i] = -numbers[i % numbers.length];
//            }
//        }
//
//        visited = new boolean[temp.length][temp.length];
//        adjust = new boolean[temp.length][temp.length];
//
//        // 인접 행렬
//        for (int i = 0; i < adjust.length; i++) {
//            int j = i + 1;
//            if (i % 2 == 0) j++; // a는 -a 와 연결될 수 없음.
//            for (; j < adjust.length; j++) {
//                if (i != j && i < j)
//            }{
//                adjust[i][j] = true;
//            }
//        }
//
//        // 인접 행렬 출력
//        //dump(adjust);
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//
//        int num = temp[0];
//        int i;
//        while (stack.size() > 0) {
//            i = stack.pop();
//            visited[i] = true;
//            for (int j = i + 1; j < adjust.length; j++) {
//                if (adjust[i][j]) {
//                    stack.push(j);
//                    num += temp[j];
//                }
//            }
//
//            if (target == num) answer++;
//        }
//
//        return answer;
//    }

    // 오빠가 알려줘서 한방에 BFS 로 푼 방법
    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int n = queue.poll();
                queue.add(n + numbers[i]);
                queue.add(n - numbers[i]);
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (target == n) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        P43165 p = new P43165();
        int[] arr = {1, 1, 1};
        System.out.println(p.solution(arr, 3));
    }
}
