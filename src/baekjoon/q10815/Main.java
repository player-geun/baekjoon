package baekjoon.q10815;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] hadNumbers;
    static int[] givenNumbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        hadNumbers = new int[N];
        for (int i = 0; i < N; i++) {
            hadNumbers[i] = sc.nextInt();
        }

        M = sc.nextInt();
        givenNumbers = new int[M];
        for (int i = 0; i < M; i++) {
            givenNumbers[i] = sc.nextInt();
        }

        Arrays.sort(hadNumbers);

        for (int i = 0; i < M; i++) {
            if (isHadNumber(givenNumbers[i])) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }

    public static boolean isHadNumber(int givenNumber) {
        int max = N - 1;
        int min = 0;
        int mid = 0;

        while (min <= max) {
            mid = (max + min) / 2;

            if (hadNumbers[mid] == givenNumber) {
                return true;
            } else if (hadNumbers[mid] > givenNumber) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
    }
}
