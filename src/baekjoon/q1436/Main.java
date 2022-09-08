package baekjoon.q1436;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;
        int cnt = 0;

        while (true) {
            result++;
            String line = String.valueOf(result);

            if (line.contains("666")) {
                cnt++;

                if (cnt == N) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
