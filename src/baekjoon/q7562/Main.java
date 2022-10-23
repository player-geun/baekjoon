package baekjoon.q7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int T, len, sx, sy, ax, ay;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            visited = new boolean[len][len];
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ax = Integer.parseInt(st.nextToken());
            ay = Integer.parseInt(st.nextToken());

            System.out.println(BFS());
        }
    }

    public static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            if (now[0] == ax && now[1] == ay) {
                return now[2];
            }

            for (int k = 0; k < 8; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < len && y < len) {
                    if (!visited[x][y]) {
                        queue.add(new int[]{x, y, now[2] + 1});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return 0;
    }
}
