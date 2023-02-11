package baekjoon.q2531;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static int N, d, k, c, count;
    static int[] sushis;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        sushis = new int[2 * N];

        for (int i = 0; i < N; i++) {
            sushis[i] = sc.nextInt();
        }

        for (int i = N; i < 2 * N; i++) {
            sushis[i] = sushis[i - N];
        }

        countNumberCases();

        System.out.println(count);
    }

    public static void countNumberCases() {
        int left = 0;
        int right = k - 1;

        while (right < 2 * N - 1) {
            int tempCount = countDifferentSushi(left, right);

            if (!isContainedFreeSushi(left, right)) {
                tempCount += 1;
            }

            count = Math.max(count, tempCount);

            left++;
            right++;
        }
    }

    public static int countDifferentSushi(int left, int right) {
        int count = 0;

        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                if (sushis[i] == sushis[j]) {
                    count++;
                }
            }
        }

        return right - left + 1 - count;
    }

    public static boolean isContainedFreeSushi(int left, int right) {
        for (int i = left; i <= right; i++) {
            if (sushis[i] == c) {
                return true;
            }
        }

        return false;
    }
}
