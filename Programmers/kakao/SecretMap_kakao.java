public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] result = solution(6, arr1, arr2);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static String bit(int n, int size) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                stringBuilder.append("#");
            } else {
                stringBuilder.append(" ");
            }
            n /= 2;
            count++;
        }
        if (count != size) {
            while(count < size) {
                stringBuilder.append(" ");
                count++;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] map = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = arr1[i] | arr2[i];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = bit(map[i], n);
        }

        return answer;
    }
}
