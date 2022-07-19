package baekjoon.q4344;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        for (int i = 0; i < C; i++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            int mean = 0;
            double count = 0;
            double result = 0;

            for (int j = 0; j < N; j++) {
                A[j] = sc.nextInt();
                mean += A[j];
            }

            mean = mean / N;

            for (int a : A) {
                if (a > mean) {
                    count ++;
                }
            }

            result = count / N * 100;

            System.out.println(String.format("%.3f", result) + "%");
        }
    }
}
