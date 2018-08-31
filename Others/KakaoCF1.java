import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int a, b;
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            a = in.nextInt();
            b = in.nextInt();
            System.out.println(reward(a,b));
        }
    }

    private static int reward(int a, int b) {
        int contest1[] = {5000000, 3000000, 2000000, 500000, 300000, 100000};
        int contest1N[] = {1,3,6,10,15,21};
        int contest2[] = {5120000, 2560000, 1280000, 640000, 320000};
        int contest2N[] = {1,3,7,15,31};

        int result = 0;
        for(int i=0; i<contest1N.length; i++){
            if(a == 0) break;
            if(a <= contest1N[i]){
                result += contest1[i];
                break;
            }
        }

        for(int i=0; i<contest2N.length; i++){
            if(b == 0) break;
            if(b <= contest2N[i]){
                result += contest2[i];
                break;
            }
        }

        return result;
    }
}
