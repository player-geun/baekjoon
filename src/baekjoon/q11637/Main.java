package baekjoon.q11637;

import java.util.Scanner;

public class Main {

    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] candidates = new int[N];
            int maxCandidate = 0;
            int maxIndex = 0;
            int sum = 0;
            boolean isOverlap = false;

            for (int i = 0; i < N; i++) {
                candidates[i] = sc.nextInt();
                if (maxCandidate < candidates[i]) {
                    maxCandidate = candidates[i];
                    maxIndex = i;
                }
                sum += candidates[i];
            }

            for (int i = 0; i < N; i++) {
                if (i != maxIndex && maxCandidate == candidates[i]) {
                    isOverlap = true;
                }
            }

            if (!isOverlap && maxCandidate >= ((sum % 2 == 0) ? sum / 2 : sum / 2 + 1)) {
                System.out.println("majority winner " + (maxIndex + 1));
            } else {
                System.out.println("no winner");
            }
        }
    }
}
