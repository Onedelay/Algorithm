package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

// 레벨 2 : 가장 큰 수
public class P42746 {
    public class Number_ {
        String value;
        int radix; // 자릿수

        public Number_(int value) {
            this.value = String.valueOf(value);
            this.radix = String.valueOf(value).length();
        }
    }

    // 이거 안됨. 아주 큰 문제 있음
    public String solution1(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Number_> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(new Number_(i));
        }

        list.sort((o2, o1) -> {
            int a = Integer.parseInt(o1.value.substring(0, 1)) - Integer.parseInt(o2.value.substring(0, 1)); // 첫번째 자리 기준으로 정렬
            if (a == 0) { // 첫번째 자릿수가 같다면 두번째 자릿수 비교
                if (o1.radix >= o2.radix) {
                    int b = Integer.parseInt(o1.value.substring(1, 2)) - Integer.parseInt(o1.value.substring(1, 2));
                    if (b == 0) { // 두번째 자릿수가 같다면 세번째 자릿수 비교
                        if (o1.radix >= o2.radix) {
                            int c = Integer.parseInt(o1.value.substring(2, 3)) - Integer.parseInt(o1.value.substring(2, 3));
                            if (c == 0) { // 세번째 자릿수가 같다면 네번째 자릿수 비교
                                if (o1.radix >= o2.radix) {
                                    return Integer.parseInt(o1.value.substring(3, 4)) - Integer.parseInt(o1.value.substring(3, 4));
                                } else return o1.value.substring(3, 4).equals("0") ? 0 : -1;
                            } else {
                                return c;
                            }
                        } else return o1.value.substring(2, 3).equals("0") ? 0 : -1;
                    } else {
                        return b;
                    }
                } else return o1.value.substring(1, 2).equals("0") ? 0 : -1; // 만약 자릿수가 더 큰 o2의 두번째 자리가 0이라면 o2보다 o1이 큼 (3 > 30)
            } else {
                return a;
            }
        });

        System.out.println(Arrays.toString(list.toArray()));

        for (Number_ n : list) {
            sb.append(n.value);
        }

        return sb.toString();
    }

    public class Number2 {
        int num;
        int[] number;
        int radix;

        public Number2(int number) {
            String temp = String.valueOf(number);
            this.num = number;
            this.number = new int[temp.length()];
            this.radix = temp.length();

            for (int i = 0; i < temp.length(); i++) {
                this.number[i] = Integer.parseInt(temp.charAt(i)+"");
            }
        }
    }

    public String solution2(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Number2> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(new Number2(i));
        }

        list.sort((o2, o1) -> {
            int a = o2.number[0] - o1.number[0];
            if (a == 0) { // 첫째 자리 수가 같을 경우
                if (o1.radix >= 2 && o2.radix >= 2) {
                    int b = o2.number[1] - o1.number[1];
                    if (b == 0) { // 둘째 자리 수가 같을 경우
                        if (o1.radix >= 3 && o2.radix >= 3) {
                            int c = o2.number[2] - o1.number[2];
                            if (c == 0) { // 셋째 자리 수가 같을 경우
                                if (o1.radix >= 4 && o2.radix >= 4) {
                                    return o2.number[3] - o1.number[3];
                                } else {
                                    if (o1.radix < o2.radix) { // 기준 값의 자릿수가 작은 경우
                                        if (o2.number[3] == 0) return 0;
                                        else return 1;
                                    } else {
                                        if (o1.number[3] == 0) return 1;
                                        else return 0;
                                    }
                                }
                            } else {
                                return c;
                            }
                        } else {
                            if (o1.radix < o2.radix) { // 기준 값의 자릿수가 작은 경우
                                if (o2.number[2] == 0) return 0;
                                else return 1;
                            } else {
                                if (o1.number[2] == 0) return 1;
                                else return 0;
                            }
                        }
                    } else {
                        return b;
                    }
                } else {
                    if (o1.radix < o2.radix) { // 기준 값의 자릿수가 작은 경우
                        if (o2.number[1] == 0) return 0;
                        else return 1;
                    } else {
                        if (o1.number[1] == 0) return 1;
                        else return 0;
                    }
                }
            } else {
                return a;
            }
        });

        System.out.println(Arrays.toString(list.toArray()));

        for (Number2 n : list) {
            sb.append(n.num);
        }

        return sb.toString();
    }

    // ------------------- 위까지 삽질의 결과물 -------------------
    // 승미한테 힌트 받고 한방에 푼 방법
    class Number {
        int value;
        String key; // 정렬 기준

        public Number(int value) {
            this.value = value;
            this.key = String.valueOf(value);

            int i = 0;
            while (key.length() != 4) {     // 3, 301 -> 3333, 3013 으로 변환하여 비교
                key += key.charAt(i % 4);
                i++;
            }
        }
    }

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Number> list = new ArrayList<>();

        for (int i : numbers) {
            list.add(new Number(i));
        }

        list.sort((o1, o2) -> Integer.parseInt(o2.key) - Integer.parseInt(o1.key));

        for (Number aList : list) {
            sb.append(aList.value);
        }

        String result = sb.toString();
        try {
            if (Integer.parseInt(result) == 0) return "0"; // 너무 큰 숫자일 경우 예외 발생(int 범위 벗어남)
        } catch (NumberFormatException e) {
            // Do - nothing
        }

        return result;
    }

    public static void main(String[] args) {
        P42746 p = new P42746();
        int numbers[] = {1000, 999, 998};
        System.out.println(p.solution(numbers));

        int numbers2[] = {6, 10, 2};
        System.out.println(p.solution(numbers2));

        int numbers3[] = {3, 30, 34, 5, 9};
        System.out.println(p.solution(numbers3));

        int numbers4[] = {0, 0, 0, 0, 0};
        System.out.println(p.solution(numbers4));
    }
}
