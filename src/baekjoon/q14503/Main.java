package baekjoon.q14503;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int N, M, startR, startC, D, time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        startR = sc.nextInt();
        startC = sc.nextInt();
        D = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        time = 1;

        if (D == 1) {
            D = 3;
        } else if (D == 3) {
            D = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        BFS();

        System.out.println(time);
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;
            map[now[0]][now[1]] = 2;

            int cnd = 5;

            while (--cnd > 0) {
                int x = now[0] + dr[D];
                int y = now[1] + dc[D];
                D++;

                if (D == 4) {
                    D = 0;
                }

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y] && map[x][y] != 1) {
                        visited[x][y] = true;
                        map[x][y] = 2;
                        queue.add(new int[]{x, y});
                        time++;
                        break;
                    }
                }
            }

            if (cnd == 0) {
                int d;
                if (D == 0) {
                    d = 3;
                } else {
                    d = D - 1;
                }

                if (d - 2 < 0) {
                    d = d + 4;
                }
                int x = now[0] + dr[d - 2];
                int y = now[1] + dc[d - 2];

                if (x >= 0 && y >= 0 && x < N && y < M){
                    if (map[x][y] != 1) {
                        queue.add(new int[]{x, y});

                        if (map[x][y] == 0) {
                            time++;
                        }
                    }
                }
            }
        }
    }
}
