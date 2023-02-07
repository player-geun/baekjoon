package baekjoon.q5525;

import java.util.Scanner;

public class Main {

    static String S, P;
    static int N, M, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = sc.next();
        P = "";

        createP();
        countPInS();

        System.out.println(count);
    }

    public static void createP() {
        for (int i = 0; i < 2 * N + 1; i++) {
            if (i % 2 == 0) {
                P += "I";
            } else {
                P += "O";
            }
        }
    }

    public static void countPInS() {
        while (S.contains(P)) {
            S = S.replaceFirst(P, "");
            count++;
        }
    }
}
