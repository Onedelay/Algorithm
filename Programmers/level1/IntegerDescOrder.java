package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerDescOrder {
    static String res = "";

    // 람다식을 이용한 풀이
    public static long solution1(long n) {
        res = "";
        Long.toString(n).chars().sorted().forEach(c -> res = (char) c + res);
        return Long.parseLong(res);
    }

    public static void main(String[] args) {
        System.out.println(solution1(118372));
    }

    // 나의 비루한 풀이
    public static long solution(long n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] strings = String.valueOf(n).split("");

        for (String s : strings) {
            arrayList.add(Integer.parseInt(s));
        }
        Collections.sort(arrayList);

        for (Integer anArrayList : arrayList) {
            sb.append(anArrayList);
        }

        return Long.parseLong(sb.reverse().toString());
    }
}
