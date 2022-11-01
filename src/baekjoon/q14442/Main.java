package baekjoon.q14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] pos;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[N][M];
        visited = new boolean[N][M][11];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                pos[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, K});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]][now[3]] = true;

            if (now[0] == N - 1 && now[1] == M - 1) {
                return now[2];
            }

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y][now[3]] && pos[x][y] == 1 && now[3] > 0) {
                        queue.add(new int[]{x, y, now[2] + 1, now[3] - 1});
                        visited[x][y][now[3]] = true;
                    } else if (!visited[x][y][now[3]] && pos[x][y] == 0) {
                        queue.add(new int[]{x, y, now[2] + 1, now[3]});
                        visited[x][y][now[3]] = true;
                    }
                }
            }
        }

        return - 1;
    }
}
