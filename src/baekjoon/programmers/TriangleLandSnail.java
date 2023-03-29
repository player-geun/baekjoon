package baekjoon.programmers;

import java.util.*;

public class TriangleLandSnail {

    static int[][] triangle;
    static int number, y, x;

    public static void main(String[] args) {
        int n = 5;

        triangle = new int[n][n];
        number = 1;

        while (true) {
            goDown();
            if(!isGoing()) break;
            goRight();
            if(!isGoing()) break;
            goDiagonal();
            if(!isGoing()) break;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] != 0) {
                    list.add(triangle[i][j]);
                }
            }
        }

        list.stream().mapToInt(i -> i).toArray();
    }

    public static boolean isGoing() {
        if (triangle[y][x] > 0) {
            return false;
        }

        return true;
    }

    public static void goDown() {
        while (true) {
            if (y >= 4) {
                y--;
                x++;
                break;
            }

            if (triangle[y][x] > 0) {
                y--;
                x++;
                break;
            }

            triangle[y++][x] = number++;
        }
    }

    public static void goRight() {
        while (true) {
            if (x >= 4) {
                x = x - 2;
                y--;
                break;
            }

            if (triangle[y][x] > 0) {
                x = x - 2;
                y--;
                break;
            }

            triangle[y][x++] = number++;
        }
    }

    public static void goDiagonal() {
        while (true) {
            if (triangle[y][x] > 0) {
                x++;
                y = y + 2;
                break;
            }

            triangle[y--][x--] = number++;
        }
    }
}


