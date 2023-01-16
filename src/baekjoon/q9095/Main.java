package baekjoon.q9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            if (n >= 2) {
                if (n >= 3) {
                    dp[3] = 4;
                }
                dp[2] = 2;
            }

            System.out.println(setDp(n));
        }
    }

    public static int setDp(int N) {
        if (dp[N] == 0) {
            dp[N] = setDp(N - 1) + setDp(N - 2) + setDp(N - 3);
        }

       return dp[N];
    }
}
