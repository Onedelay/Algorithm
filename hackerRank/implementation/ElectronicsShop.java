package hackerRank.implementation;

public class ElectronicsShop {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1, sum;
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                sum = keyboard + drive;
                if (sum > max && sum <= b) max = sum;
            }
        }
        return max;
    }
}
