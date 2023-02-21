package baekjoon.q1189;

import java.util.*;

public class Main {

    static int R, C, K, count;
    static String[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new String[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.substring(j, j + 1);
            }
        }

        isVisited[R - 1][0] = true;
        findWayOfK(R - 1, 0, 1);

        System.out.println(count);
    }

    public static void findWayOfK(int y, int x, int length) {
        if (y == 0 && x == C - 1) {
            if (length == K) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < C && newY < R && newX >= 0 && newY >= 0) {
                if (!isVisited[newY][newX] && !map[newY][newX].equals("T")) {
                    isVisited[newY][newX] = true;
                    findWayOfK(newY, newX, length + 1);
                    isVisited[newY][newX] = false;
                }
            }
        }
    }
}
