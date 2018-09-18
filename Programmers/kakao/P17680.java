package programmers.kakao;

// 카카오 블라인드 문제 - 캐시
public class P17680 {
    public static class Node {
        String value;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;
        int amount = 0;

        LinkedList(int size) {
            this.head = new Node();
            this.size = size;
        }

        void add(String city) {
            if (amount >= size) {
                head = head.next; // head 제거
            }
            Node node = new Node();
            node.value = city;
            node.next = null;

            if (isEmpty()) {
                head = node;
                tail = node;
                head.next = null;
            } else {
                Node p = head;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = node;
                tail = node;
                amount++;
            }
        }

        private boolean isEmpty() {
            return head == null;
        }

        boolean isContain(String city) {
            Node cur = head;
            Node pre = head;
            while ((cur = cur.next) != null) {
                if ((cur.value).equals(city)) {
                    System.out.println("Cache hit");
                    if (cur != tail) {
                        pre.next = cur.next; // 이전 노드 next 에 현재 노드를 건너 뛰고 다음 node 가리키도록
                        tail.next = cur; // 현재 노드를 맨 뒤로 옮기기
                        tail = cur; // 현재 노드를 tail 로
                        tail.next = null;
                    }
                    return true;
                }
                pre = cur;
            }
            System.out.println("Cache miss");
            return false;
        }

        void dump() {
            Node p = head;
            while ((p = p.next) != null) {
                System.out.print(p.value + ", ");
            }
        }

        void tailDump() {
            System.out.println("tail : " + tail.value);
        }
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
        String[] cities2 = {"Jeju", "Pangyo", "NewYork", "newyork"};

        System.out.println(solution(30, cities2));
    }

    // 직접 클래스를 구현할 필요 없이 ArrayList 나 Queue 를 이용해서 풀 수 있다. 나중에 시간나면 활용해보도록... ㅠㅠ
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList list = new LinkedList(cacheSize);

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        for (String city : cities) {
            if (list.isContain(city)) {
                answer += 1;
            } else {
                list.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}
