package baekjoon.q1654;

import java.util.Scanner;

public class Main {

    static int K, N;
    static long min, max, mid;
    static int[] lanLines;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        lanLines = new int[K + 1];

        min = 1;
        max = Integer.MIN_VALUE;
        for (int i = 1; i <= K; i++) {
            lanLines[i] = sc.nextInt();
            max = Math.max(max, lanLines[i]);
        }

        findMaxLanLineLength();

        System.out.println(max);
    }

    public static void findMaxLanLineLength() {
        while (min <= max) {
            mid = (min + max) / 2;

            long sum = 0;
            for (int i = 1; i <= K; i++) {
                sum += lanLines[i] / mid;
            }

            if (N > sum) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
    }
}
