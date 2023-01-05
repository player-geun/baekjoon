package baekjoon.q2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, maxWaterDepth, maxSafeZoneCnt;
    static int[][] sunkPos;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        findMaxSafeZone();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sunkPos = new int[N][N];
        visited = new boolean[N][N];
        maxWaterDepth = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sunkPos[i][j] = Integer.parseInt(st.nextToken());

                if (maxWaterDepth < sunkPos[i][j]) {
                    maxWaterDepth = sunkPos[i][j];
                }
            }
        }
    }

    public static void findMaxSafeZone() {
        maxSafeZoneCnt = 0;
        for (int waterDepth = 0; waterDepth < maxWaterDepth + 1; waterDepth++) {
            visited = new boolean[N][N];
            int safeZoneCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && sunkPos[i][j] > waterDepth) {
                        safeZoneCnt += DFS(i, j, waterDepth);
                    }

                }
            }
            maxSafeZoneCnt = Math.max(maxSafeZoneCnt, safeZoneCnt);
        }
    }

    public static int DFS(int x, int y, int waterDepth) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if (!visited[newX][newY] && sunkPos[newX][newY] > waterDepth) {
                    DFS(newX, newY, waterDepth);
                }
            }
        }
        return 1;
    }

    public static void output() {
        System.out.println(maxSafeZoneCnt);
    }
}
