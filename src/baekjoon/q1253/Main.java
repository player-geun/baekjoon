package baekjoon.q1253;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int count = 0;

        for (int i = 0; i < N; i++) {

            int startIndex = 0;
            int endIndex = N - 1;
            int sum = A[i];

            while (startIndex < endIndex) {

                if (A[startIndex] + A[endIndex] > sum) {
                    endIndex--;
                } else if (A[startIndex] + A[endIndex] < sum) {
                    startIndex++;
                } else {

                    if (startIndex != i && endIndex != i) {

                        count++;
                        break;
                    } else if (startIndex == i) {
                        startIndex++;
                    } else if (endIndex == i) {
                        endIndex--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
