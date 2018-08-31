package hackerRank.implementation;

public class PickingNumbers {
    static int pickingNumbers(int[] a) {
        int[] numCount = new int[100]; // 0~99
        int max = 0, tmp;

        for (int i : a){
            numCount[i-1]++;
        }

        for (int i=0; i<numCount.length-1; i++) {
            tmp = numCount[i]+numCount[i+1];
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,1,2};
        System.out.println(pickingNumbers(a));
    }
}
