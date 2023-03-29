package baekjoon.q2563;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] drawingPaper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        drawingPaper = new int[100 + 1][100 + 1];

        for (int i = 0; i < N; i++) {
            placePaper(101 - sc.nextInt(), sc.nextInt());
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (drawingPaper[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }

    public static void placePaper(int y, int x) {
        for (int i = y - 9; i <= y; i++) {
            for (int j = x; j < x + 10; j++) {
                drawingPaper[i][j] += 1;
            }
        }
    }
}
