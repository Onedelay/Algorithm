import java.util.ArrayList;
import java.util.Arrays;

public class DescSort {
    public static void main(String[] args) {
        System.out.println(solution2("Zbcdefg"));
    }

    static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> arr = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }

        arr.sort((o1, o2) -> o1 > o2 ? -1 : 1);

        for (Character c : arr) {
            answer.append(String.valueOf(c));
        }

        return answer.toString();
    }

    static String solution2(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new StringBuilder(new String(array)).reverse().toString();
    }
}
