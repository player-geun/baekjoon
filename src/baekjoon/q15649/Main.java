package baekjoon.q15649;

import java.util.Scanner;

public class Main {

    static int N, M;
    static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isUsed = new boolean[N + 1];

        findPermutation(0, 0);
    }

    public static void findPermutation(int length, int num) {
        if (length == M) {
            String temp = String.valueOf(num);
            for (int i = 0; i < M; i++) {
                System.out.print(temp.charAt(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i] && num % 10 < i) {
                isUsed[i] = true;
                findPermutation(length + 1, num * 10 + i);
                isUsed[i] = false;
            }
        }
    }
}
