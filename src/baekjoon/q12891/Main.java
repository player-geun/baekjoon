package baekjoon.q12891;

import java.util.Scanner;

public class Main {

    static int[] A;
    static int[] B;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();

        String str = sc.next();

        A = new int[4];
        B = new int[4];
        count = 0;
        char[] C = str.toCharArray();

        for (int i = 0; i < 4; i++) {
            B[i] = sc.nextInt();

            if (B[i] == 0) {
                count++;
            }
        }

        int result = 0;

        for (int i = 0; i < P; i++) {
            Add(C[i]);
        }

        if (count == 4) {
            result++;
        }

        int startIndex = 0;
        int endIndex = P;

        while (endIndex < S) {

            Add(C[endIndex++]);
            Remove(C[startIndex++]);

            if (count == 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void Add(char c) {

        switch (c) {

            case 'A':

                A[0]++;
                if (A[0] == B[0]) {
                    count++;
                }
                break;

            case 'C':

                A[1]++;
                if (A[1] == B[1]) {
                    count++;
                }
                break;

            case 'G':

                A[2]++;
                if (A[2] == B[2]) {
                    count++;
                }
                break;

            case 'T':

                A[3]++;
                if (A[3] == B[3]) {
                    count++;
                }
                break;
        }
    }

    private static void Remove(char c) {

        switch (c) {

            case 'A':

                if (A[0] == B[0]) {
                    count--;
                }
                A[0]--;
                break;

            case 'C':

                if (A[1] == B[1]) {
                    count--;
                }
                A[1]--;
                break;

            case 'G':

                if (A[2] == B[2]) {
                    count--;
                }
                A[2]--;
                break;

            case 'T':

                if (A[3] == B[3]) {
                    count--;
                }
                A[3]--;
                break;
        }
    }
}
