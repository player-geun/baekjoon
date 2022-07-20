package baekjoon.q1920;

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

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            int start = 0;
            int end = N - 1;
            int result = 0;

            while (start <= end) {
                int median = (end + start) / 2;

                if (num == A[median]) {
                    result = 1;
                    break;
                } else if (num > A[median]) {
                    start = median + 1;
                } else {
                    end = median - 1;
                }
            }

            System.out.println(result);
        }
    }
}
