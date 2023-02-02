package baekjoon.q14646;

import java.util.Scanner;

public class Main {

    static int N, max, sum;
    static int[] menuNumbers;
    static int[] table;

    public static void main(String[] args) {
        input();
        spinTable();
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        menuNumbers = new int[2 * N + 1];
        table = new int[N + 1];

        for (int i = 1; i < 2 * N + 1; i++) {
            menuNumbers[i] = sc.nextInt();
        }
    }

    public static void spinTable() {
        for (int i = 1; i < 2 * N + 1; i++) {
            if (table[menuNumbers[i]] == 0) {
                sum++;
                table[menuNumbers[i]] = 1;
            } else {
                sum --;
            }

            max = Math.max(max, sum);
        }
    }

    public static void output() {
        System.out.println(max);
    }
}
