package baekjoon.q11051;

import java.util.Scanner;

public class Main {

    static int N, K;
    static long[][] dp;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new long[N + 1][N + 1];
    }

    public static void setDp() {
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
                }
            }
        }
    }

    public static void output() {
        System.out.println(dp[N][K] % 10007);
    }
}
