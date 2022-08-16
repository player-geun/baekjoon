package baekjoon.q10026;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static String[][] color;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, result1, result2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        color = new String[N][N];
        visited = new boolean[N][N];
        result1 = 0;
        result2 = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();

            for (int j = 0; j < N; j++) {
                color[i][j] = line.substring(j, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    BFS(i, j);
                    result1++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Objects.equals(color[i][j], "G")) {
                    color[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    BFS(i, j);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    static void BFS(int i, int j) {
        if (visited[i][j]) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if ((Objects.equals(color[x][y], color[now[0]][now[1]])) && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
