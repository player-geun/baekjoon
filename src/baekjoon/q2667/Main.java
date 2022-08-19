package baekjoon.q2667;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] house;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, result, cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        house = new int[N * N];
        result = 0;
        cnt = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        int k = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    house[k++] = cnt;
                    cnt = 0;
                    result++;
                }
            }
        }

        Arrays.sort(house);
        System.out.println(result);
        for (int i : house) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;
            cnt++;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
