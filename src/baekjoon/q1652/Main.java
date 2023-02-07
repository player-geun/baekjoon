package baekjoon.q1652;

import java.util.Scanner;

public class Main {

    static String[][] room;
    static int N, row, column;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        room = new String[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.substring(j, j + 1);
            }
        }

        countSleepPlace();

        System.out.println(row + " " + column);
    }

    public static void countSleepPlace() {
        int sumRow = 0;
        int sumColumn = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j].equals(".")) {
                    sumRow++;
                } else {
                    if (sumRow >= 2) {
                        row++;
                        sumRow = 0;
                        break;
                    }
                    sumRow = 0;
                }
            }
            if (sumRow >= 2) {
                row++;
            }
            sumRow = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[j][i].equals(".")) {
                    sumColumn++;
                } else {
                    if (sumColumn >= 2) {
                        column++;
                        sumColumn = 0;
                        break;
                    }
                    sumColumn = 0;
                }
            }

            if (sumColumn >= 2) {
                column++;
            }
            sumColumn = 0;
        }
    }
}
