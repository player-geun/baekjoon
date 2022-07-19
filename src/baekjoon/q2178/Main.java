package baekjoon.q2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 상하좌우 탐색을 위한 배열을 선언
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][M];
        visited = new boolean[N][M];

        // 문자열로 입력받아서 substring 함수를 사용하여 분해
        for (int i = 0; i < N; i++) {
            String line = sc.next();

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    static void BFS(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[i][j] = true;

            // 상하좌우 인접 노드 확인하여 큐에 삽입
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                // 좌표 유효성 검사
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    // 0인 곳으로는 못가고 true가 아닌 곳을 큐에 삽입
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        // now에는 깊이가 계속 누적해서 더해짐
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
