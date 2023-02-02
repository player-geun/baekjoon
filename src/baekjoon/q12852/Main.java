package baekjoon.q12852;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp;
    static int[] trace;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];
        trace = new int[N + 1];

        setDpAndTrace();

        System.out.println(dp[N]);


        int index = N;
        while (index != 0) {
            System.out.print(index + " ");
            index = trace[index];
        }
    }

    public static void setDpAndTrace() {
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;

            for (int j = 1; j < i; j++) {
                if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    trace[i] = i / 2;
                }

                if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    trace[i] = i / 3;
                }
            }
        }
    }
}
