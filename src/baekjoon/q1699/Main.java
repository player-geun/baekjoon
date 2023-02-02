package baekjoon.q1699;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1];
    }

    public static void setDp() {
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
    }

    public static void output() {
        System.out.println(dp[N]);
    }
}
