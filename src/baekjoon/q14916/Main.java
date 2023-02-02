package baekjoon.q14916;

import java.util.Scanner;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[100001];
    }

    public static void setDp() {
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 6; i <= n; i++) {
            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
                dp[i] = -1;
            } else if (dp[i - 2] == -1) {
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 5] == -1) {
                dp[i] = dp[i - 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
            }
        }
    }

    public static void output() {
        System.out.print(dp[n]);
    }
}
