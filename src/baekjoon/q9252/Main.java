package baekjoon.q9252;

import java.util.*;
import java.io.*;

public class Main {

    static String firstString, secondString;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        firstString = sc.next();
        secondString = sc.next();
        dp = new int[firstString.length() + 1][secondString.length() + 1];

        setDp();

        if (dp[firstString.length()][secondString.length()] == 0) {
            System.out.println(dp[firstString.length()][secondString.length()]);
            return;
        }
        System.out.println(dp[firstString.length()][secondString.length()]);

        int index =1;
        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                if (dp[i][j] == index) {
                    System.out.print(secondString.charAt(j - 1));
                    index++;
                }
            }
        }
    }

    public static void setDp() {
        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
