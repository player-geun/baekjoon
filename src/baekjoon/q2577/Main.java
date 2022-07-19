package baekjoon.q2577;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] A = new int[10];
        int result = 1;

        for (int i = 0; i < 3; i++) {
            result *= sc.nextInt();
        }

        String str = String.valueOf(result);

        for (int j = 0; j < str.length(); j++) {
            int a = Integer.parseInt(str.substring(j, j + 1));
            A[a]++;
        }

        for (int i : A) {
            System.out.println(i);
        }
    }
}
