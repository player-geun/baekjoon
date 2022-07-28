package baekjoon.q1850;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long A = sc.nextLong();
        long B = sc.nextLong();
        long result = gcd(A, B);

        while (result > 0) {
            sb.append("1");
            result --;
        }

        System.out.println(sb);
    }

    public static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A % B);
        }
    }
}
