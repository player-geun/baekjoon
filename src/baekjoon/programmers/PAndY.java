package baekjoon.programmers;

public class PAndY {

    public static void main(String[] args) {
        String s = "pPoooyY";
        char[] arr = s.toCharArray();

        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'p' || arr[i] == 'P') {
                pCount++;
            } else if (arr[i] == 'y' || arr[i] == 'Y') {
                yCount++;
            }
        }
    }
}
