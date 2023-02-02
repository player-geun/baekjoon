package baekjoon.q1965;

import java.util.Scanner;

public class Main {

    static int n;
    static int[] dp;
    static int[] boxSizes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n];
        boxSizes = new int[n];

        for (int i = 0; i < n; i++) {
            boxSizes[i] = sc.nextInt();
        }

        setDp();

        int max = 0;
        for (int size : dp) {
            max = Math.max(max, size);
        }

        System.out.println(max);
    }

    public static void setDp() {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxSizes[i] > boxSizes[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
    }
}
