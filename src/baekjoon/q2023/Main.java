package baekjoon.q2023;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DFS(2, 1, N);
        DFS(3, 1, N);
        DFS(5, 1, N);
        DFS(7, 1, N);
    }

    static void DFS(int num, int cipher, int N) {

        if (cipher == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }

            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, cipher + 1, N);
            }
        }
    }

    static boolean isPrime(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}


