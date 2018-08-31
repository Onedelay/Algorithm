package hackerRank.implementation;

public class TheHuddleRace {
    static int hurdleRace(int k, int[] height) {
        int max = 0;
        for (int i : height) {
            if (i > max) max = i;
        }

        return max - k > 0 ? max - k : 0;
    }
}
