package baekjoon.q2565;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int lineCount;
    static int[][] telephonePoles;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lineCount = sc.nextInt();
        telephonePoles = new int[lineCount + 1][2];
        dp = new int[lineCount + 1];

        for (int i = 1; i <= lineCount; i++) {
            telephonePoles[i][0] = sc.nextInt();
            telephonePoles[i][1] = sc.nextInt();
        }

        Arrays.sort(telephonePoles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        setDp();

        int max = 0;
        for (int i = 1; i <= lineCount; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(lineCount - max);
    }

    public static void setDp() {
        for (int i = 1; i <= lineCount; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (telephonePoles[i][1] > telephonePoles[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
}
