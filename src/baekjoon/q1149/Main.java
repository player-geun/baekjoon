package baekjoon.q1149;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] dp;
    static int[][] costs;

    public static void main(String[] args) {
        input();
        setRecDp(N - 1, 0);
        setRecDp(N - 1, 1);
        setRecDp(N - 1, 2);
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N][3];
        costs = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
    }

    public static int setRecDp(int index, int color) {
        if (dp[index][color] == 0) {
            if (color == 0) {
                dp[index][color] = Math.min(setRecDp(index - 1, 1),
                        setRecDp(index - 1, 2)) + costs[index][color];
            } else if (color == 1) {
                dp[index][color] = Math.min(setRecDp(index - 1, 0),
                        setRecDp(index - 1, 2)) + costs[index][color];
            } else {
                dp[index][color] = Math.min(setRecDp(index - 1, 0),
                        setRecDp(index - 1, 1)) + costs[index][color];
            }
        }

        return dp[index][color];
    }

    public static void output() {
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
