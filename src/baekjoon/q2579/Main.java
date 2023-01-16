package baekjoon.q2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int stairCount;
    static Integer[] dp;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        input();
        findMaxStairValue(stairCount);
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stairCount = Integer.parseInt(br.readLine());
        dp = new Integer[stairCount + 1];
        stairs = new int[stairCount + 1];

        for (int currentFloor = 1; currentFloor <= stairCount; currentFloor++) {
            stairs[currentFloor] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if (stairCount >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
    }

    public static int findMaxStairValue(int currentFloor) {
        if (dp[currentFloor] == null) {
            dp[currentFloor] = Math.max(findMaxStairValue(currentFloor - 2),
                    findMaxStairValue(currentFloor - 3) + stairs[currentFloor - 1]) + stairs[currentFloor];
        }

        return dp[currentFloor];
    }

    public static void output() {
        System.out.println(dp[stairCount]);
    }
}
