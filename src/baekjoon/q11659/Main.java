package baekjoon.q11659;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] sumArray = new int[1000000];

        int N = sc.nextInt();
        int M = sc.nextInt();

        sumArray[1] = sc.nextInt();

        for (int i = 2; i <= N; i++) {
            sumArray[i] = sumArray[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            sb.append((sumArray[sc.nextInt() - 1] - sumArray[sc.nextInt()]) * -1).append("\n");
        }

        System.out.println(sb);
    }
}
