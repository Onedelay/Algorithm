package programmers.level2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

// 레벨 2 : 프린터
public class P42587 {
    class Node implements Comparable<Node> {
        private int UUID;
        private int G;
        private int H;

        public Node(int UUID, int g, int h) {
            this.UUID = UUID;
            G = g;
            H = h;
        }

        public int getF() {
            return G + H;
        }

        @Override
        public int compareTo(Node target) {
            if (this.getF() == target.getF()) return 0;
            return this.getF() < target.getF() ? 1 : -1;
        }

        public String toString() {
            return String.format("location: %d, priority: %d", UUID, H);
        }
    }

    // 삽질의 결과물
    public int solution_(int[] priorities, int location) {
        int answer = -1;
        PriorityQueue<Node> pQueue = new PriorityQueue<>();

        int id = 0;
        for (int i : priorities) {
            pQueue.offer(new Node(id++, 1, i));
        }

        int count = 0;
        while (!pQueue.isEmpty()) {
            Node node = pQueue.poll();
            System.out.println(node.toString());
            count++;
            if (node != null && node.UUID == location) return count;
        }

        return answer;
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();

        // 큐에 (index, priority) 쌍으로 집어넣기
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Pair<>(i, priorities[i]));
        }

        int max = -1;

        ArrayList<Integer> order = new ArrayList<>();

        // 큐가 비었을 때 까지
        while (!list.isEmpty()) {
            // 최대값 찾기
            for (Pair<Integer, Integer> aList : list) {
                if (aList.getValue() > max) max = aList.getValue();
            }

            while (true) {
                // 최대값을 찾을 경우 dequeue
                if (max == list.get(0).getValue()) {
                    order.add(list.get(0).getKey()); // index 만 뽑아서 순서(order)목록에 add
                    list.remove(0);
                    max = -1;
                    break;
                } else { // 그렇지 않을 경우 dequeue 후 다시 enqueue
                    list.add(list.get(0));
                    list.remove(0);
                }
            }
        }

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i) == location) return i + 1;
        }

        return answer;
    }
}
