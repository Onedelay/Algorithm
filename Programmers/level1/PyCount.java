public class pyCount {
    public static void main(String[] args){
        System.out.println(solution("ppPPyyYY"));
    }

    static boolean solution(String s) {
        int c1 = 0, c2 = 0;
        String str = s.toLowerCase();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'p') c1++;
            if(str.charAt(i) == 'y') c2++;
        }

        if(c1 == 0 && c2 == 0) return true;
        else return c1 == c2;
    }
}
