package baekjoon.q1747;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[10000001];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }

            for (int j = i + i; j < A.length; j += i) {
                A[j] = 0;
            }
        }

        for (int i = 2; i < A.length; i++) {
            if (A[i] >= N) {
                int num = A[i];
                int reverse = 0;

                while (num != 0) {
                    int digit = num % 10;
                    reverse = reverse * 10 + digit;
                    num /= 10;
                }

                if (A[i] == reverse) {
                    System.out.println(A[i]);

                    return;
                }
            }
        }
    }
}
