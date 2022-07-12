package baekjoon.q11399;

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

        int sum = 0;
        int result = 0;

        for (int a : A) {
            sum += a;
            result += sum;
        }

        System.out.println(result);
    }
}
