package baekjoon.q17136;

import java.util.Scanner;

public class Main {

    static int[][] paper;
    static int[] countsOfColorPaper = {0, 5, 5, 5, 5, 5};
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        paper = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        selectColorPapers(0, 0, 0);

        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(minCount);
        return;
    }

    public static void selectColorPapers(int y, int x, int countOfColorPaper) {
        if (y >= 9 && x > 9) {
            minCount = Math.min(minCount, countOfColorPaper);
            return;
        }

        if (countOfColorPaper >= minCount) {
            return;
        }

        if (x > 9) {
            selectColorPapers(y + 1, 0, countOfColorPaper);
            return;
        }

        if (paper[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                if (countsOfColorPaper[i] > 0 && isAttach(y, x, i)) {
                    attach(y, x, i);
                    countsOfColorPaper[i]--;
                    selectColorPapers(y, x + 1, countOfColorPaper + 1);
                    detach(y, x, i);
                    countsOfColorPaper[i]++;
                }
            }
        } else {
            selectColorPapers(y, x + 1, countOfColorPaper);
        }
    }

    public static void attach(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                paper[i][j] = 0;
            }
        }
    }

    public static void detach(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                paper[i][j] = 1;
            }
        }
    }

    public static boolean isAttach(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }

                if (paper[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
