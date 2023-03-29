package baekjoon.q25644;

import java.util.Scanner;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] chart = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            chart[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], chart[i] - min);
            min = Math.min(min, chart[i]);
        }

        System.out.println(dp[N]);
    }
}
