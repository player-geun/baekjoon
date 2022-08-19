package baekjoon.q1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int T, M, N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int q = 0; q < T; q++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = 0;
                }
            }

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y][x] = 1;
            }

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        BFS(i, j);
                        result ++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
