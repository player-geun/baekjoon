package baekjoon.q15624;

import java.util.Scanner;

public class Main {

    static int n;
    static int MOD = 1000000007;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[1000001];

        setDp();

        System.out.println(dp[n]);
    }

    public static void setDp() {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
    }
}
