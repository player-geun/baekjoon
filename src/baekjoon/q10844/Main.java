package baekjoon.q10844;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    static int N;
    static long[][] dp;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new long[N + 1][10];
    }

    public static void setDp() {
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }
    }

    public static void output() {
        long result = 0;

        for(int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % 1000000000);
    }
}
