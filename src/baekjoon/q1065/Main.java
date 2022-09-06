package baekjoon.q1065;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;

        if (N < 100) {
            for (int i = 1; i <= N; i++) {
                cnt++;
            }

            System.out.println(cnt);
        } else {
            cnt = 99;

            for (int i = 100; i <= N; i++) {
                String line = String.valueOf(i);
                int a = Integer.parseInt(line.substring(0, 1));
                int b = Integer.parseInt(line.substring(1, 2));
                int c = Integer.parseInt(line.substring(2, 3));

                if (a - b == b - c) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
