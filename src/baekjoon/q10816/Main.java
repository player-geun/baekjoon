package baekjoon.q10816;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int[] arr = new int[20000001];

        for (int i = 0; i < M; i++) {
            arr[sc.nextInt() + 10000000]++;
        }

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            sb.append(arr[sc.nextInt() + 10000000]).append(" ");
        }

        System.out.println(sb);
    }
}
