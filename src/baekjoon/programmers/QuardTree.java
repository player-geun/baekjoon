package baekjoon.programmers;

import java.util.Queue;

public class QuardTree {

    private static int oneCount, zeroCount;

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};

        DFS(new Square(0, 0, arr.length), arr);

        System.out.println(zeroCount + " " + oneCount);
    }

    public static void DFS(Square square, int[][] arr) {
        if (isAllSameValue(square, arr)) {
            increaseCount(square, arr);
            return;
        }

        DFS(new Square(square.y, square.x, square.side / 2), arr);
        DFS(new Square(square.y, square.x + square.side / 2, square.side / 2), arr);
        DFS(new Square(square.y + square.side / 2, square.x, square.side / 2), arr);
        DFS(new Square(square.y + square.side / 2, square.x + square.side / 2, square.side / 2), arr);
    }

    public static void increaseCount(Square square, int[][] arr) {
        if (arr[square.y][square.x] == 0) {
            zeroCount++;
            return;
        }

        oneCount++;
    }

    public static boolean isAllSameValue(Square square, int[][] arr) {
        int startValue = arr[square.y][square.x];

        for (int i = square.y; i < square.y + square.side; i++) {
            for (int j = square.x; j < square.x + square.side; j++) {
                if (startValue != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static class Square {

        private int y;
        private int x;
        private int side;

        public Square(int y, int x, int side) {
            this.y = y;
            this.x = x;
            this.side = side;
        }
    }
}
