package baekjoon.q3055;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static String[][] map;
    static boolean[][] visitedWater;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] start;
    static Queue<int[]> queue;
    static boolean isSuccess;
    static int R, C;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new String[R][C];
        visited = new boolean[R][C];
        visitedWater = new boolean[R][C];
        queue = new LinkedList<>();
        start = new int[2];

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.substring(j, j + 1);

                if (Objects.equals(map[i][j], "S")) {
                    queue.add(new int[]{i, j});
                    map[i][j] = "1";
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (Objects.equals(map[i][j], "*")) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int result = BFS();

        if (isSuccess) {
            System.out.println(result);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static int BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            boolean isWater;

            if (Objects.equals(map[now[0]][now[1]], "*")) {
                isWater = true;
                visitedWater[now[0]][now[1]] = true;
            } else {
                isWater = false;
                visited[now[0]][now[1]] = true;
            }

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < R && y < C) {
                    if (!Objects.equals(map[x][y], "*") && !visited[x][y] && !isWater && !Objects.equals(map[x][y], "X")) {
                        if (Objects.equals(map[x][y], "D")) {
                            isSuccess = true;
                            return Integer.parseInt(map[now[0]][now[1]]);
                        }

                        map[x][y] = String.valueOf(Integer.parseInt(map[now[0]][now[1]]) + 1);
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }

                    if (!Objects.equals(map[x][y], "D") && !visitedWater[x][y] && isWater && !Objects.equals(map[x][y], "X")) {
                        visitedWater[x][y] = true;
                        map[x][y] = "*";
                        queue.add(new int[]{x, y});
                    }

                }
            }
        }
        return 0;
    }
}
