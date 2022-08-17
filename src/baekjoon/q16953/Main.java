package baekjoon.q16953;

import java.util.Scanner;

public class Main {

    static int A, B, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        cnt = 1;

        while (A != B) {
            if (B < A) {
                System.out.println(-1);
                return;
            }

            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                System.out.println(-1);
                return;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
