package baekjoon.q23029;

import java.util.Scanner;

public class Main {

    static int[][][] dp;
    static int N;
    static int[] food;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[100001][2][2];
        food = new int[100001];

        for (int i = 0; i < N; i++) {
            food[i] = sc.nextInt();
        }
    }

    public static void setDp() {
        dp[0][0][0] = food[0];
        dp[1][1][0] = food[0] + food[1] / 2;
        dp[1][0][0] = food[1];
        dp[2][1][0] = food[1] + food[2] / 2;
        dp[2][0][1] = food[0] + food[2];

        for (int i = 3; i < N; i++) {
            dp[i][0][1] = Math.max(Math.max(dp[i - 2][1][0], dp[i - 2][0][1]), dp[i - 2][0][0]) + food[i];
            dp[i][1][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]) + food[i] / 2;
            dp[i][0][0] = Math.max(Math.max(dp[i - 3][1][0], dp[i - 3][0][1]), dp[i - 3][0][0]) + food[i];
        }
    }

    public static void output() {

        System.out.println(Math.max(Math.max(dp[N - 1][1][0], dp[N - 1][0][1]), dp[N - 1][0][0]));
    }
}
