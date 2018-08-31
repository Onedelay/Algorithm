package hackerRank.implementation;

public class DayOfTheProgrammer {
    public static void main(String[] args) {
        int n = 1918;
        solution(n);
    }

    private static void solution(int n) {
        int sum = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        if (n < 1918) {
            if (n % 4 == 0) {
                sum += 1;
            }
        } else {
            if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) {
                sum += 1;
            }
        }

        if (n == 1918) sum -= 13;

        System.out.print(String.format("%02d.%02d.%d", 256 - sum, 9, n));
    }
}
