package baekjoon.q6236;

import java.util.Scanner;

public class Main {

    static int N, M, min, max, mid, result;
    static int[] amountsBeUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        amountsBeUsed = new int[N];

        for (int i = 0; i < N; i++) {
            amountsBeUsed[i] = sc.nextInt();
            min = Math.max(min, amountsBeUsed[i]);
        }

        max = 10000 * 100000;

        findMinAmount();

        System.out.println(min);
    }

    public static void findMinAmount() {
        while (min <= max) {
            mid = (min + max) / 2;

            int amountBeRemained = mid;
            int numberWithdrawals = 1;
            for (int i = 0; i < N; i++) {
                if (amountBeRemained < amountsBeUsed[i]) {
                    numberWithdrawals++;
                    amountBeRemained = mid;
                }
                amountBeRemained -= amountsBeUsed[i];

            }

            if (M >= numberWithdrawals) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
    }
}
