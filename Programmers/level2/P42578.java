package programmers.level2;

import java.util.HashMap;

// 레벨 2 : 위장
public class P42578 {
    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] str : clothes) {
            if (!hashMap.containsKey(str[1])) hashMap.put(str[1], 1);
            else hashMap.put(str[1], hashMap.get(str[1]) + 1);
        }

        int[] count = new int[hashMap.size()];
        int idx = 0;
        for (Integer i : hashMap.values()) {
            count[idx++] = i;
        }

        // 점화식을 유추할 수 있는데 난 못했다...
        for (int i = 0; i < count.length; i++) {
            answer = answer + answer * count[i] + count[i];
        }

        return answer;
    }
}
