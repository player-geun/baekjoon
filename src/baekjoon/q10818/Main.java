package baekjoon.q10818;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < N; i++) {
            if (max < A[i]) {
                max = A[i];
            }

            if (min > A[i]) {
                min = A[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
