package baekjoon.q11057;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        countAscentNumber();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 2][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
    }

    public static void countAscentNumber() {
        for (int i = 2; i < N + 2; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
    }

    public static void output() {
        System.out.println(dp[N + 1][0]);
    }
}
