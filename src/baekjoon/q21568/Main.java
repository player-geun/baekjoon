package baekjoon.q21568;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int gcd = gcd(a, b);

        if (c % gcd != 0) {
            System.out.println(-1);
        } else {
            int mok = c / gcd;
            int[] ret = excute(a, b);
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }

    public static int gcd(int a, int b) {

        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static int[] excute(int a, int b) {

        int[] ret = new int[2];

        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;

            return ret;
        }

        int q = a / b;
        int[] v = excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;

        return ret;
    }
}
