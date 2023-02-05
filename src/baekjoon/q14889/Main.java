package baekjoon.q14889;

import java.util.Scanner;

public class Main {

    static int N, minDifference;
    static int[][] capacityValues;
    static boolean[] isBelong;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        minDifference = Integer.MAX_VALUE;
        capacityValues = new int[N + 1][N + 1];
        isBelong = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                capacityValues[i][j] = sc.nextInt();
            }
        }

        findMinDifference(0, 0);

        System.out.println(minDifference);
    }

    public static void findMinDifference(int personnel, int before) {
        if (personnel == N / 2) {
            minDifference = Math.min(minDifference, calculateMinDifference());
        }

        for (int i = 1; i <= N; i++) {
            if (!isBelong[i] && before < i) {
                isBelong[i] = true;
                findMinDifference(personnel + 1, i);
                isBelong[i] = false;
            }
        }
    }

    public static int calculateMinDifference() {
        int sumOfFirstTeamCapacityValues = 0;
        int sumOfSecondTeamCapacityValues = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isBelong[i] && isBelong[j]) {
                    sumOfFirstTeamCapacityValues += capacityValues[i][j];
                } else if(!isBelong[i] && !isBelong[j]) {
                    sumOfSecondTeamCapacityValues += capacityValues[i][j];
                }
            }
        }

        return Math.abs(sumOfFirstTeamCapacityValues - sumOfSecondTeamCapacityValues);
    }
}
