package baekjoon.q11660;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[][] sumArray = new int[1025][1025];

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                sumArray[i][j] = sumArray[i][j - 1] + sc.nextInt();
            }
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {

                sumArray[i][j] = sumArray[i - 1][j] + sumArray[i][j];
            }
        }

        for (int i = 0; i < M; i++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = sumArray[x2][y2] - sumArray[x2][y1 - 1] - sumArray[x1 - 1][y2] + sumArray[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
