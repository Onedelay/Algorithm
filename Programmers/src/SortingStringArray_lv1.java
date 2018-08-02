import java.util.ArrayList;
import java.util.Collections;

public class SortingStringArray_lv1 {

    /*
     * 가장 간단한 방법으로, compare 메소드를 활용해 버블 정렬하기
     * a - b > 0 일 경우, b가 사전순으로 앞에있다.
     * 반대로 a - b < 0 일 경우, a가 사전순으로 앞에있다.
     * 사전순으로 앞에 있을 수록 int value 가 작다는 것을 의미한다.
     */
    private static int compare(char a, char b) {
        return b - a;
    }

    private static String[] solution1(String[] strings, int index) {
        String temp;
        int result;
        for (int i = strings.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                result = compare(strings[j].charAt(index), strings[j + 1].charAt(index));
                if (result < 0) {
                    temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                } else if (result == 0) {
                    if (strings[j].compareTo(strings[j + 1]) > 0) {
                        temp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = temp;
                    }
                }
            }
        }

        return strings;
    }

    private static String[] solution2(String[] strings, int index) {
        String[] answer;

        ArrayList<String> arr = new ArrayList<>();
        for (String string : strings) {
            arr.add("" + string.charAt(index) + string);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }

        return answer;
    }

    static private void print(String[] strings) {
        System.out.print("[");
        for (String string : strings) {
            System.out.print("'" + string + "', ");
        }
        System.out.print("]");
    }

    public static void main(String args[]) {
//        String[] strings = {"car", "abcd", "cdx", "bed", "sun", "bear", "cda"};
//        String[] strings = {"a", "b", "c","e", "a", "b", "s"};
//        String[] strings = {"abcd", "cdx", "abc", "abcde"};
        String[] strings = {"xxxx", "xxx", "xx", "x", "xa", "xb", "xc"};
        print(solution1(strings, 0));
        System.out.println();
        print(solution2(strings, 0));
    }
}
