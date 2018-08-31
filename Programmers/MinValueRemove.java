import java.util.Arrays;

public class MinValueRemove {
    public static void main(String[] args) {
        int[] arr = {10};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        int[] answer;
        if (arr.length == 1) {
            return new int[]{-1};
        }

        answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        for (int i = 0, j = 0; i < answer.length; i++, j++) {
            if (index == i) j++;
            answer[i] = arr[j];
        }

        return answer;
    }
}

