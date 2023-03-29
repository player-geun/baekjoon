package baekjoon.q3184;

import java.util.*;

public class Main {

    static int R, C, wolf, sheep, resultOfWolf, resultOfSheep;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                String point = line.substring(j, j + 1);
                if (point.equals("#")) {
                    map[i][j] = -1;
                } else if (point.equals("v")) {
                    map[i][j] = 1;  //늑대
                } else if (point.equals("o")) {
                    map[i][j] = 2;  //양
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);

                    if (wolf < sheep) {
                        wolf = 0;
                        resultOfSheep += sheep;
                        sheep = 0;
                    } else {
                        sheep = 0;
                        resultOfWolf += wolf;
                        wolf = 0;
                    }
                }
            }
        }

        System.out.println(resultOfSheep + " " + resultOfWolf);
    }

    public static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if (map[y][x] == 1) {
            wolf++;
        } else if (map[y][x] == 2) {
            sheep++;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newY < R && newX < C) {
                if (!isVisited[newY][newX] && map[newY][newX] >= 0) {
                    dfs(newY, newX);
                }
            }
        }
    }
}
