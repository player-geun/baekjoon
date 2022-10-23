package baekjoon.q2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] pos;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pos = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                pos[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0, 1, 0, visited);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    // 행, 열, 지나온 거리, 벽 뚫은 여부
    static void BFS(int i, int j, int d, int w, boolean[][][] visited) {
        visited[i][j][w] = true;

        if (i == N - 1 && j == M - 1) {
            if (min > d) {
                min = d;
            }

            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < N && y >= 0 && y < M) {
                if (!visited[x][y][w]) {
                    if (pos[x][y] == 1 && w == 0) {
                        int newD = d + 1;
                        BFS(x, y, newD, 1, visited);
                    } else if (pos[x][y] != 1 && w == 0) {
                        int newD = d + 1;
                        BFS(x, y, newD, 0, visited);
                    }else if (pos[x][y] != 1 && w == 1) {
                        int newD = d + 1;
                        BFS(x, y, newD, 1, visited);
                    }
                }
            }
        }
    }
}
