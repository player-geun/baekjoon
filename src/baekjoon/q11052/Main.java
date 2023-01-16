package baekjoon.q11052;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp;
    static int[] cards;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1];
        cards = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cards[i] = sc.nextInt();
        }
    }

    public static void setDp() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }
    }

    public static void output() {
        System.out.println(dp[N]);
    }
}
