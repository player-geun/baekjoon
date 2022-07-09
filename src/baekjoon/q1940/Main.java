package baekjoon.q1940;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        while (startIndex < endIndex) {

            if (A[startIndex] + A[endIndex] == M) {

                count++;
                startIndex++;
                endIndex--;
            } else if (A[startIndex] + A[endIndex] > M) {
                endIndex--;
            } else {
                startIndex++;
            }
        }

        System.out.println(count);
    }
}
