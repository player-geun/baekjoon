package baekjoon.q18405;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K, S, X, Y;
    static int[][] pos;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[N][N];
        visited = new boolean[N][N];
        PriorityQueue<int[]> virus = new PriorityQueue<>(new MyComparator());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());

                if (pos[i][j] != 0) {
                    virus.add(new int[]{i, j, 0, pos[i][j]});
                }
            }
        }

        //S초 후. (X,Y) 위치의 바이러스 종류 출력
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        BFS(virus);

        System.out.println(pos[X - 1][Y - 1]);
    }

    static void BFS(PriorityQueue<int[]> virus) {
        Queue<int[]> queue = new LinkedList<>();

        while (!virus.isEmpty()) {
            queue.add(virus.poll());
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            if (now[2] == S) {
                return;
            }

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (!visited[x][y] && pos[x][y] == 0) {
                        queue.add(new int[]{x, y, now[2] + 1});
                        pos[x][y] = pos[now[0]][now[1]];
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

    static class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[3] - o2[3];
        }
    }
}
