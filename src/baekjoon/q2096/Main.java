package baekjoon.q2096;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] minDp;
    static int[][] maxDp;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        minDp = new int[N + 1][4];
        maxDp = new int[N + 1][4];
        map = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        setDp();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 3; i++) {
            max = Math.max(max, maxDp[N][i]);
        }
        System.out.print(max + " ");

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            min = Math.min(min, minDp[N][i]);
        }
        System.out.println(min);
    }

    public static void setDp() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                minDp[i][j] = minDp[i - 1][j] + map[i][j];
                maxDp[i][j] = maxDp[i - 1][j] + map[i][j];

                if (j == 1) {
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j + 1] + map[i][j]);
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j + 1] + map[i][j]);
                } else if (j == 3) {
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j - 1] + map[i][j]);
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j - 1] + map[i][j]);
                } else {
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j + 1] + map[i][j]);
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j - 1] + map[i][j]);
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j + 1] + map[i][j]);
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j - 1] + map[i][j]);
                }
            }
        }
    }
}
