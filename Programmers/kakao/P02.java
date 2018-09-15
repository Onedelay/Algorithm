package programmers.kakao;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class P02 {
    public int[] solution(int N, int[] stages) {
        int[] answer;
        ArrayList<Pair<Integer, Float>> arrayList = new ArrayList<>();
        Arrays.sort(stages);
        int lastStage = stages[stages.length-1];
        for (int i = 1; i <= lastStage; i++) {
            int fail = 0, ing = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) fail++;
                if (stages[j] >= i + 1) ing++;
            }
            arrayList.add(new Pair<>(i, (float) fail / ing));
        }

        System.out.println(arrayList.toString());

        arrayList.sort((o2, o1) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue().compareTo(o2.getValue());
        });

        System.out.println(arrayList.toString());

        answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i).getKey();
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
