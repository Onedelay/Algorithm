package hackerRank.implementation;

public class CountingValleys {
    static int countingValleys(int n, String s) {
        char[] walk = s.toCharArray();
        int count = 0;
        int valley = 0;
        boolean ud = false;

        for (char c : walk) {
            if (c == 'U') {
                count++;
                if (count >= 0 && ud) {
                    ud = false;
                    valley++;
                }
            } else {
                count--;
                if (count < 0) {
                    ud = true;
                }
            }
        }

        return valley;
    }
}
