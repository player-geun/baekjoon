package baekjoon.q3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, maxCandyCount;
    static String[][] board;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    public static void main(String[] args) throws IOException {
        input();
        findMaxCandyCount();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            String inputtedLine = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = inputtedLine.substring(j, j + 1);
            }
        }
    }

    public static void findMaxCandyCount() {
        int candyCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                candyCount = moveCandy(i, j);
                maxCandyCount = Math.max(candyCount, maxCandyCount);
            }
        }
    }

    public static int moveCandy(int x, int y) {
        int candyCount = 0;
        int maxCandyCount = 0;
        for (int i = 0; i < 2; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                swapCandy(x, y, newX, newY);
                candyCount = countCandy(x, y, newX, newY);
                maxCandyCount = Math.max(candyCount, maxCandyCount);
                swapCandy(x, y, newX, newY);
            }
        }

        return maxCandyCount;
    }

    public static void swapCandy(int x, int y, int newX, int newY) {
        String tempCandy = board[x][y];
        board[x][y] = board[newX][newY];
        board[newX][newY] = tempCandy;
    }

    public static int countCandy(int x, int y, int newX, int newY) {
        int maxCandyCount = 0;

        for (int i = 0; i < N; i++) {
            int sumCandyCount = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j].equals(board[i][j + 1])) {
                    sumCandyCount++;
                } else {
                    sumCandyCount = 1;
                }

                maxCandyCount = Math.max(maxCandyCount, sumCandyCount);
            }
        }

        for (int i = 0; i < N; i++) {
            int sumCandyCount = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i].equals(board[j + 1][i])) {
                    sumCandyCount++;
                } else {
                    sumCandyCount = 1;
                }

                maxCandyCount = Math.max(maxCandyCount, sumCandyCount);
            }
        }

        return maxCandyCount;
    }

    public static void output() {
        System.out.println(maxCandyCount);
    }
}
