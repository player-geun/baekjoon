package baekjoon.q2805;

import java.util.Scanner;

public class Main {

    static int N, M, min, max, mid;
    static int[] lengthOfTrees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lengthOfTrees = new int[N];

        for (int i = 0; i < N; i++) {
            lengthOfTrees[i] = sc.nextInt();
            max = Math.max(lengthOfTrees[i], max);
        }

        findMaxHeight();

        System.out.println(max);
    }

    public static void findMaxHeight() {
        while (min <= max) {
            long sumOfCutTree = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < N; i++) {
                if (lengthOfTrees[i] > mid) {
                    sumOfCutTree += lengthOfTrees[i] - mid;
                }
            }

            if (sumOfCutTree >= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }
}
