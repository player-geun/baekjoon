package baekjoon.q1427;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int[] B = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            B[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < B.length; i++) {

            int max = i;

            for (int j = i + 1; j < B.length; j++) {
                if (B[j] > B[max]) {
                    max = j;
                }
            }

            if (B[i] < B[max]) {
                int temp = B[i];
                B[i] = B[max];
                B[max] = temp;
            }
        }

        for (int a : B) {
            System.out.print(a);
        }
    }
}
