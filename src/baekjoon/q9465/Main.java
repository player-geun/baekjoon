package baekjoon.q9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] board = new int[2][n + 1];
            dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + board[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + board[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
