package baekjoon.q3052;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] A = new int[42];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();

            A[a % 42]++;
        }

        for (int a : A) {
            if (a != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
