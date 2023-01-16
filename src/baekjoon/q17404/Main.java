package baekjoon.q17404;

import java.util.Scanner;

public class Main {

    static int N;
    static int RED = 0, GREEN = 1, BLUE = 2;
    static int[][] paintCosts;
    static int[] minPaintCosts;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        paintCosts = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        minPaintCosts = new int[3];

        for (int i = 1; i <= N; i++) {
            paintCosts[i][RED] = sc.nextInt();
            paintCosts[i][GREEN] = sc.nextInt();
            paintCosts[i][BLUE] = sc.nextInt();
        }
    }

    public static void setDp() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    dp[1][j] = paintCosts[1][j];
                else
                    dp[1][j] = 1001;
            }

            for (int k = 2; k <= N; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + paintCosts[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + paintCosts[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + paintCosts[k][2];
                if (k == N) {
                    if (i == 0) {
                        minPaintCosts[i] = Math.min(dp[N][1], dp[N][2]);
                    }
                    if (i == 1) {
                        minPaintCosts[i] = Math.min(dp[N][0], dp[N][2]);
                    }
                    if (i == 2) {
                        minPaintCosts[i] = Math.min(dp[N][0], dp[N][1]);
                    }
                }
            }
        }
    }

    public static void output() {
        System.out.println(Math.min(Math.min(minPaintCosts[0], minPaintCosts[1]), minPaintCosts[2]));
    }
}
