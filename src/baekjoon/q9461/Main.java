package baekjoon.q9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T, N;
    static long[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();
            setDp();
            output();
        }
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
    }

    public static void setDp() {
        for (int i = 6; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
    }

    public static void output() {
        System.out.println(dp[N]);
    }
}
