package baekjoon.q7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] box;
    static Queue<int []> start;
    static int N, M, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();       // 가로
        N = sc.nextInt();       // 세로
        box = new int[N][M];
        visited = new boolean[N][M];
        start = new LinkedList<>();
        result = 0;
        //box 채워넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();

                if (box[i][j] == 1) {
                    start.offer(new int[]{i, j});
                }
            }
        }
        //BFS 시작
        while (!start.isEmpty()) {
            BFS();
            result++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result - 1);
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();

        while (!start.isEmpty()) {
            queue.offer(start.poll());
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (box[x][y] != -1 && !visited[x][y]) {
                        visited[x][y] = true;
                        if (box[x][y] == 0) {
                            box[x][y] = 1;
                            start.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
