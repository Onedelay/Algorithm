package programmers.level1;

import java.util.Arrays;

// 레벨 1 : k번째 수
public class P42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];
            int[] arr = new int[end - start + 1];

            if (start == end) arr[0] = array[start - 1];
            else {
                for (int j = start - 1; j < end; j++) {
                    arr[j - start + 1] = array[j];
                }
            }

            Arrays.sort(arr);
            answer[i] = arr[index - 1];
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
