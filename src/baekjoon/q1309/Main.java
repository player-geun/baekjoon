package baekjoon.q1309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1][3];

        setDp();

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum % 9901);
    }

    public static void setDp() {
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
    }
}
