package baekjoon.q1934;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int a = A;
            int b = B;

            if (A > B) {
                while (A % B != 0) {
                    int mod = A % B;
                    A = B;
                    B = mod;
                }

                sb.append(a / B * b).append("\n");
            } else {
                while (B % A != 0) {
                    int mod = B % A;
                    B = A;
                    A = mod;
                }

                sb.append(a / A * b).append("\n");
            }
        }

        System.out.println(sb);
    }
}
