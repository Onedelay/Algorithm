package hackerRank.implementation;

public class CatsAndMouse {
    static String catAndMouse(int x, int y, int z) {
        int diffA = Math.abs(x - z);
        int diffB = Math.abs(y - z);

        if (diffA == diffB) return "Mouse C";
        else if (diffA < diffB) return "Cat A";
        else return "Cat B";
    }
}
