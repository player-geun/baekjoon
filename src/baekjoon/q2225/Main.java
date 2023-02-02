package baekjoon.q2225;

import java.util.Scanner;

public class Main {

    static int N, K;
    static int MOD = 1000000000;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new int[201][201];

        setDp();

        System.out.println(dp[N][K] % MOD);
    }

    public static void setDp() {
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
    }
}
