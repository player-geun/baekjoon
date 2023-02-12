package baekjoon.q16139;

import java.util.*;

public class Main {

    static String S;
    static int q;
    static int[][] cumulativeSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        q = sc.nextInt();
        cumulativeSum = new int[S.length()][26];
        cumulativeSum[0][S.charAt(0) - 'a']++;

        for (int i = 1; i < S.length(); i++) {
            int alphabet = S.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                cumulativeSum[i][j] = cumulativeSum[i - 1][j];
            }

            cumulativeSum[i][alphabet]++;
        }

        for (int i = 0; i < q; i++) {
            String alphabet = sc.next();
            int start = sc.nextInt();
            int end = sc.nextInt();

            if (start == 0) {
                System.out.println(cumulativeSum[end][alphabet.charAt(0) - 'a']);
            } else {
                System.out.println(cumulativeSum[end][alphabet.charAt(0)- 'a'] - cumulativeSum[start - 1][alphabet.charAt(0)- 'a']);
            }
        }
    }
}
