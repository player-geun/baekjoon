package baekjoon.q2217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] result = new int[N];

        // 입력
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(A);

        int end = N;

        for (int i = 0; i < N; i++) {
            result[i] = A[i] * end--;
        }

        Arrays.sort(result);

        System.out.println(result[N - 1]);
    }
}
