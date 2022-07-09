package baekjoon.q10986;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] sumArray = new long[N];
        long[] C = new long[M];

        long count = 0;

        sumArray[0] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            sumArray[i] = sumArray[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < N; i++) {

            int remainder = (int) (sumArray[i] % M);

            if (remainder == 0) {
                count++;
            }

            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {

            if (C[i] > 1) {

                count = count + (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(count);
    }
}
