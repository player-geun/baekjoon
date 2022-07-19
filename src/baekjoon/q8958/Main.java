package baekjoon.q8958;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();

            for (int j = 0; j < line.length(); j++) {
                if (line.substring(j, j + 1).equals("O")) {
                    count++;
                    result += count;
                    continue;
                }
                count = 0;
            }

            System.out.println(result);

            count = 0;
            result = 0;
        }
    }
}
