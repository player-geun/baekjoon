package baekjoon.q14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] pos;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int safePos = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(safePos);
    }

    public static void DFS(int depth) {
        if (depth == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pos[i][j] == 0) {
                    pos[i][j] = 1;
                    DFS(depth + 1);
                    pos[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] virusPos = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusPos[i][j] = pos[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusPos[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y] && virusPos[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        virusPos[x][y] = 2;
                        visited[x][y] = true;
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusPos[i][j] == 0) {
                    count ++;
                }
            }
        }

        safePos = Math.max(safePos, count);
    }
}
