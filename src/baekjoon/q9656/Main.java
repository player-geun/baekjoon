package baekjoon.q9656;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[1001];

        setDp();

        if (dp[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

    public static void setDp() {
        dp[1] = 2;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= N; i++) {
            if (dp[i - 1] == 2 || dp[i - 3] == 2) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
        }
    }
}
