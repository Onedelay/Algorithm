package hackerRank.implementation;

public class BeautifulDays {
    static int beautifulDays(int i, int j, int k) {
        String str;
        float f;
        int count = 0;
        for (int o = i; o <= j; o++) {
             str = new StringBuilder(Integer.toString(o)).reverse().toString();
            f = Math.abs( o - Integer.parseInt(str)) / (float)k ;
            System.out.println(f);
            if ( (int)f == f ) count++;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(beautifulDays(20, 23, 6));
    }
}
