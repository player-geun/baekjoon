package baekjoon.q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][][] tomatoes;
    private static boolean[][][] visited;
    private static int time;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        tomatoes = new int[H][N][M];
        visited = new boolean[H][N][M];
        List<int[]> startPointList = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        startPointList.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        if (isPre(M, N, H)) {
            System.out.println(0);
            return;
        }

        spread(M, N, H, startPointList);

        if (!isAll(M, N, H)) {
            System.out.println(-1);
            return;
        }

        System.out.println(time);
    }

    private static boolean isPre(int M, int N, int H) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isAll(int M, int N, int H) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[i][j][k] && tomatoes[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void spread(int M, int N, int H, List<int[]> startPointList) {
        Queue<int[]> queue = new LinkedList<>(startPointList);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]][now[2]] = true;

            for (int i = 0; i < 6; i++) {
                int nextX = now[2] + dx[i];
                int nextY = now[1] + dy[i];
                int nextH = now[0] + dh[i];
                time = Math.max(time, now[3]);

                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nextH < 0 || nextH >= H) {
                    continue;
                }

                if (visited[nextH][nextY][nextX] || tomatoes[nextH][nextY][nextX] == -1 ||
                        tomatoes[nextH][nextY][nextX] == 1) {
                    continue;
                }

                queue.add(new int[]{nextH, nextY, nextX, now[3] + 1});
                visited[nextH][nextY][nextX] = true;
            }
        }
    }
}
