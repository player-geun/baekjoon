package baekjoon.q2512;

import java.util.Scanner;

public class Main {

    static int N, M, min, max, mid;
    static int[] budget;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        budget = new int[N + 1];
        max = Integer.MIN_VALUE;
        min = 0;
        for (int i = 1; i <= N; i++) {
            budget[i] = sc.nextInt();
            max = Math.max(max, budget[i]);
        }
        M = sc.nextInt();

        findMaxLine();

        System.out.println(max);
    }

    public static void findMaxLine() {
        while (min <= max) {
            mid = (min + max) / 2;

            int allBudget = 0;
            for (int i = 1; i <= N; i++) {
                allBudget += (budget[i] >= mid) ? mid : budget[i];
            }

            if (allBudget > M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
    }
}
