package baekjoon.q1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] triangle;
    static int[] dp;

    public static void main(String[] args) {

    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        triangle = new int[n][n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void setDp(int row) {
        if (dp[row] == 0) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < row + 1; i++) {
                sum = dp[row - 1] + triangle[row][i];
                max = Math.max(max, sum);
            }
        }
    }
}
