package baekjoon.q2583;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int M, N, K, size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        size = 1;
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            for (int k = a; k < c; k++) {
                for (int j = b; j < d; j++) {
                    map[M - j - 1][k] = -1;
                }
            }
        }

        int result = 0;
        int[] A = new int[M * N];
        int a = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int temp = BFS(i, j);
                result += temp;

                if (temp == 1) {
                    A[a++] = size;
                    size = 1;
                }
            }
        }

        System.out.println(result);

        Arrays.sort(A);

        if (result == 0) {
            System.out.println(0);
        } else {
            for (int i : A) {
                if (i == 0) {
                    continue;
                }
                System.out.print(i + " ");
            }
        }
    }

    public static int BFS(int i, int j) {
        if (visited[i][j] || map[i][j] == -1) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < M && y < N) {
                    if (map[x][y] != -1 && !visited[x][y]) {
                        visited[x][y] = true;
                        size++;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        return 1;
    }
}
