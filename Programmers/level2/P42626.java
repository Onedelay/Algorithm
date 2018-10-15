package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

// 레벨 2 : 더 맵게
public class P42626 {
    // 힙을 안쓴 방법
    // 실패에 시간초과;;
    public int solution1(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : scoville) {
            list.add(i);
        }

        int i = 0;
        int size = list.size();
        while (i != size) {
            if (list.get(i) < K && i + 1 < size) { // 기준보다 낮으면
                list.set(i, list.get(i) + list.get(i + 1) * 2);
                list.remove(i + 1);
                size--;
                answer++;
            }
            i++;
        }

        if (list.size() == 1 && list.get(0) < K) return -1;

        return answer;
    }

    // 2개 틀렸고, 시간초과!
    // 시간초과때문에라도 힙 써야한다..
    public int solution2(int[] scoville, int K) {
        int answer = 0;

        for (int i = 0; i < scoville.length; i++) {
            if (scoville[i] < K) {
                if (i + 1 < scoville.length) {
                    int a = scoville[i] > scoville[i + 1] ? scoville[i] * 2 + scoville[i + 1] : scoville[i + 1] * 2 + scoville[i];
                    scoville[i + 1] = a;
                    answer++;

                    Arrays.sort(scoville, i + 1, scoville.length);
                }
            }
        }

        if (scoville[scoville.length - 1] < K) return -1;

        return answer;
    }

    class MinHeap {
        private int[] Heap;
        private int size;
        private int index; // 마지막 인덱스

        private static final int FRONT = 0;

        public MinHeap(int[] arr, int size) {
            this.size = size;
            this.index = size - 1;
            Heap = new int[size];
            Heap[0] = Integer.MIN_VALUE;

            System.arraycopy(arr, 0, Heap, 0, arr.length);
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private int leftChild(int pos) {
            return (2 * pos);
        }

        private int rightChild(int pos) {
            return (2 * pos) + 1;
        }

        private boolean isLeaf(int pos) {
            return pos >= size / 2 && pos <= size;
        }

        private void swap(int fpos, int spos) {
            int tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }

        private void minHeapify(int pos) {
            if (!isLeaf(pos)) {
                if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                    if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    } else {
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
            }
        }

        void minHeap() {
            for (int pos = (size - 1)/ 2; pos >= 0; pos--) {
                minHeapify(pos);
            }
        }

        void insert(int element) {
            size++;
            Heap[++index] = element;
            int current = index;

            while (Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        int pop() {
            size--;
            int popped = Heap[FRONT];
            Heap[FRONT] = Heap[index--];
            minHeapify(FRONT);
            return popped;
        }

        int peek() {
            return Heap[FRONT];
        }
    }

    // 아니 이거 힙 문제라면서 왜 큐로 풀리냐?
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Arrays.sort(scoville);
        MinHeap heap = new MinHeap(scoville, scoville.length);
        heap.minHeap();

        while (heap.peek() < K) {
            if (heap.size > 1) {
                int a = heap.pop();
                int b = heap.pop();
                if (a > b) {
                    heap.insert(a * 2 + b);
                } else {
                    heap.insert(a + b * 2);
                }
                answer++;
            } else {
                if (heap.peek() < K) return -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42626 p = new P42626();
        int[] test1 = {1,1,1,1,1,1,1,1,1};
        System.out.println(p.solution(test1, 100));
    }
}
