package baekjoon.q18353;

import java.util.*;

public class Main {

    static int N;
    static int[] fightingPowers;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        fightingPowers = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            fightingPowers[i] = sc.nextInt();
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (fightingPowers[i] < fightingPowers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int number : dp) {
            max = Math.max(max, number);
        }
        System.out.println(N - max);
    }
}
