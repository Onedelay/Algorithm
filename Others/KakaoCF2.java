import java.util.Scanner;

public class Test2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        double min = Double.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            double value = solution(arr, i);
            if (value < min) min = value;
        }

        System.out.println(min);
    }

    private static double var(int[] arr, int a, int b) {
        double sum = 0;
        double avg;
        double v = 0.0f;
        for (int i = a; i < b; i++) {
            sum += arr[i];
        }
        avg = sum / (b - a);

        for (int i = a; i < b; i++) {
            v += (arr[i] - avg) * (arr[i] - avg);
        }

        v /= (b - a);
        return v;
    }

    private static double std(double var) {
        return Math.sqrt(var);
    }

    private static double solution(int[] arr, int K) {
        double min = Double.MAX_VALUE;
        double temp;
        for (int i = 0; i < arr.length - (K - 1); i++) {
            temp = std(var(arr, i, i + K));
            if (temp < min) min = temp;
        }

        return min;
    }
}
