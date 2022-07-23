package baekjoon.q2588;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        String str = String.valueOf(B);
        char[] arr = str.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            int a = Integer.parseInt(String.valueOf(arr[i]));

            System.out.println(A * a);
        }

        System.out.println(A * B);
    }
}
