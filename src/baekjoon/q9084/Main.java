package baekjoon.q9084;

import java.util.Scanner;

public class Main {

    static int T, N, M;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            int[] coins = new int[N];

            for (int i = 0; i < N; i++) {
                coins[i] = sc.nextInt();
            }

            M = sc.nextInt();
            dp = new int[M + 1];

            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
