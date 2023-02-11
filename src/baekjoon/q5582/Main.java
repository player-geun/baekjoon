package baekjoon.q5582;

import java.util.Scanner;

public class Main {

    static String firstString, secondString;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        firstString = sc.next();
        secondString = sc.next();
        dp = new int[firstString.length() + 1][secondString.length() + 1];

        findMaxSubString();

        int max = 0;
        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }

    public static void findMaxSubString() {
        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    dp[i][j]++;
                }
            }
        }

        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                if (dp[i][j] >= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
    }
}
