package baekjoon.q11060;

import java.util.*;

public class Main {

    static int N;
    static int[] miro;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        miro = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            miro[i] = sc.nextInt();
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;

            for (int j = 0; j < miro[j]; j++) {
                if (i + j >= N) {
                    continue;
                }
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }
}
