package baekjoon.q2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] dp;
    static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[k + 1];
        coins = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }

        setDp();

        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }

    public static void setDp() {
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
    }
}
