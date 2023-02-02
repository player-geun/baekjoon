package baekjoon.q11055;

import java.util.Scanner;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] numbers;
    static int[] dp;

    public static void main(String[] args) {
        input();
        setDp();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    public static void setDp() {
        for (int i = 0; i < N; i++) {
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[j] + numbers[i], dp[i]);
                }
            }
        }
    }

    public static void output() {
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
