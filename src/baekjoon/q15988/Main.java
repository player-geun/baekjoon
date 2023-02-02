package baekjoon.q15988;

import java.util.Scanner;

public class Main {

    static int T, n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            dp = new int[n + 1];

            setDp();

            System.out.println(dp[n]);
        }
    }

    public static void setDp() {
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
            if (n > 2) {
                dp[3] = 4;
            }
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
    }
}
