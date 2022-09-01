package baekjoon.q4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int C, R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            C = sc.nextInt();
            R = sc.nextInt();

            if (C == 0 && R == 0) {
                break;
            }

            map = new int[R][C];
            visited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        sum += BFS(i, j);
                    }
                }
            }

            System.out.println(sum);
        }
    }

    static int BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int k = 0; k < 4; k++) {
                int r = now[0] + dr[k];
                int c = now[1] + dc[k];

                if (r >= 0 && c >= 0 && r < R && c < C) {
                    if (!visited[r][c] && map[r][c] != 0) {
                        queue.add(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }

                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < R && y < C) {
                    if (!visited[x][y] && map[x][y] != 0) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return 1;
    }
}
