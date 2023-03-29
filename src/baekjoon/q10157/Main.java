package baekjoon.q10157;

import java.util.*;

public class Main {

    static int C, R, K, peopleNumber;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        K = sc.nextInt();
        map = new int[R][C];

        bfs();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == K) {
                    System.out.println(j + 1 + " " + (i + 1));
                    return;
                }
            }
        }

        System.out.println(0);
    }

    public static void bfs() {
        int y = 0;
        int x = 0;
        int direction = 0;

        while (validateFourDirection(y, x)) {
            int[] newPoints = allocateMap(y, x, direction++);
            y = newPoints[0];
            x = newPoints[1];

            if (direction > 3) {
                direction = 0;
            }
        }

        map[y][x] = ++peopleNumber;
    }

    public static boolean validateFourDirection(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY <0 || newX >= C || newY >= R) return true;
            if(map[newY][newX] == 0) return true;
        }

        return false;
    }

    public static int[] allocateMap(int y, int x, int direction) {
        while (validateSameDirection(y, x, direction)) {
            map[y][x] = ++peopleNumber;
            x = x + dx[direction];
            y= y + dy[direction];
        }

        return new int[]{y, x};
    }

    public static boolean validateSameDirection(int y, int x, int direction) {
        x = x + dx[direction];
        y= y + dy[direction];
        if(x < 0 || y <0 || x >= C || y >= R) return false;
        if(map[y][x] > 0) return false;

        return true;
    }
}
