package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 레벨 2 : 다리를 지나는 트럭
public class P42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        Queue<Integer> list = new LinkedList<>();

        int weightSum = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            if (bridge_length != list.size()) { // 다리가 꽉 차지 않을 경우
                if (weightSum + truck_weights[i] <= weight) { // 다리 무게도 꽉 차지 않을 경우
                    weightSum += truck_weights[i];
                    list.add(truck_weights[i]);
                } else {
                    i--;
                    list.add(0); // dummy 데이터
                }
                answer++;
            } else {
                int tmp = list.poll();
                i--;
                weightSum -= tmp;
            }
        }

        return answer + bridge_length;
    }
}
