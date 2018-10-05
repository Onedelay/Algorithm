package programmers.level2;

// 레벨 2 : 쇠막대기
public class P42585 {
    public int solution(String arrangement) {
        int answer = 0, cnt = 0;
        char[] arrange = arrangement.toCharArray();

        for (int i = 0; i < arrange.length; i++) {
            if (arrange[i] == '(') {
                if (i < arrange.length - 1 && arrange[i + 1] == ')') { // 레이저일경우 싹둑
                    answer += cnt;
                    i++;
                } else {
                    cnt++;
                }
            } else {
                cnt--;
                answer += 1;
            }
        }

        return answer;
    }
}
