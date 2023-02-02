package baekjoon.q14863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static Road[] roads;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N][K + 1];
        roads = new Road[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i] = new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        findMaxAmount();

        int max = 0;
        for (int i = 1; i <= K; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);
    }

    public static void findMaxAmount() {
        dp[0][roads[0].walkingTime] = roads[0].walkingAmount;
        dp[0][roads[0].cycleTime] = Math.max(dp[0][roads[0].cycleTime], roads[0].cycleAmount);

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                } else {
                    if (j + roads[i].walkingTime <= K) {
                        dp[i][j + roads[i].walkingTime] = Math.max(
                                dp[i][j + roads[i].walkingTime], dp[i - 1][j] + roads[i].walkingAmount);
                    }

                    if (j + roads[i].cycleTime <= K) {
                        dp[i][j + roads[i].cycleTime] = Math.max(
                                dp[i][j + roads[i].cycleTime], dp[i - 1][j] + roads[i].cycleAmount);
                    }
                }
            }
        }
    }

    public static class Road {
        int walkingTime;
        int walkingAmount;
        int cycleTime;
        int cycleAmount;

        public Road(int walkingTime, int walkingAmount, int cycleTime, int cycleAmount) {
            this.walkingTime = walkingTime;
            this.walkingAmount = walkingAmount;
            this.cycleTime = cycleTime;
            this.cycleAmount = cycleAmount;
        }
    }
}
