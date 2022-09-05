package baekjoon.q10610;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.next();
        Integer[] A = new Integer[line.length()];

        for (int i = 0; i < line.length(); i++) {
            A[i] = Integer.parseInt(line.substring(i, i + 1));
        }

        Arrays.sort(A, Collections.reverseOrder());

        if (A[line.length() - 1] != 0) {
            System.out.println(-1);
            return;
        }


        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int a : A) {
            System.out.print(a);
        }
    }
}
