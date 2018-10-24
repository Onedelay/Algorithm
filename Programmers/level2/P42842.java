package programmers.level2;

// 레벨 2 : 카펫
public class P42842 {
    // 내 풀이는 엄청 느리고 지저분하다
    // 수학공식을 알아야하는건가?
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        // 안쪽 카펫의 배수 구하기
        for (int i = 1; i <= red; i++) {
            for (int j = red; j >= 1; j--) {
                // 안쪽 카펫의 배수_1 * 2 + 배수_2 * 2 + 4 == 갈색카펫의 수
                if (i * 2 + j * 2 + 4 == brown) {
                    System.out.printf("[%d, %d]\n", i, j);
                    answer[0] = i + 2;
                    answer[1] = j + 2;
                    break;
                }
                if (answer[0] >= answer[1] && answer[0] * answer[1] == brown + red) break;
            }
        }

        // 정답은 [배수_1 + 2, 배수_2 + 2]
        System.out.printf("[%d, %d]\n", answer[0], answer[1]);
        return answer;
    }

    // 전혀 이해 안되는 풀이. 나중에 토의해보기!!!
    public int[] solution_1(int brown, int red) {
        int a = (brown + 4) / 2;
        int b = red + 2 * a - 4;
        int[] answer = {(int) (a + Math.sqrt(a * a - 4 * b)) / 2, (int) (a - Math.sqrt(a * a - 4 * b)) / 2};
        return answer;
    }
}
