package baekjoon.q6593;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][][] pos;
    static boolean[][][] visited;
    static int L, R, C;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int[] dz = {0, 0, 0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) {
                return;
            }

            pos = new int[L][R][C];
            visited = new boolean[L][R][C];
            int sx = 0, sy = 0, sz = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = sc.next();

                    for (int k = 0; k < C; k++) {
                        String a = line.substring(k, k + 1);

                        if (a.equals("S")) {
                            pos[i][j][k] = 0;
                            sx = i;
                            sy = j;
                            sz = k;
                        } else if (a.equals("#")) {
                            pos[i][j][k] = -1;
                        } else if (a.equals("E")) {
                            pos[i][j][k] = -2;
                        } else {
                            pos[i][j][k] = 0;
                        }
                    }
                }
            }

            BFS(sx, sy, sz);
        }
    }

    static void BFS(int sx, int sy, int sz) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, sz, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]][now[2]] = true;

            if (pos[now[0]][now[1]][now[2]] == -2) {
                System.out.println("Escaped in " + now[3] + " minute(s).");
                return;
            }

            for (int k = 0; k < 6; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                int z = now[2] + dz[k];

                if (x >= 0 && y >= 0 && z >= 0 && x < L && y < R && z < C) {
                    if (!visited[x][y][z] && pos[x][y][z] != -1) {
                        queue.add(new int[]{x, y, z, now[3] + 1});
                        visited[x][y][z] = true;
                    }
                }
            }
        }

        System.out.println("Trapped!");
    }
}
