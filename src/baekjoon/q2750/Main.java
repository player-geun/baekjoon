package baekjoon.q2750;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[1000];

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {

            arr[i] = in.nextInt();
        }

        for (int j = 1; j < n; j++) {

            for (int i = 0; i < n - j; i++) {

                if (arr[i] > arr[i + 1]) {

                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
