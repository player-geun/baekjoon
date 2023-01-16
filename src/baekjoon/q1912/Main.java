package baekjoon.q1912;

import java.util.Scanner;

public class Main {

    static int N, maxSum;
    static int[] dp;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N];
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    public static void setDp() {
        dp[0] = numbers[0];
        maxSum = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
    }

    public static void output() {
        System.out.println(maxSum);
    }
}
