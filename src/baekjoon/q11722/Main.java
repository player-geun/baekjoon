package baekjoon.q11722;

import java.util.Scanner;

public class Main {

    static int N;
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
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] < numbers[j] && dp[j] + 1 >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }

    public static void output() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
