package baekjoon.programmers;

import java.util.*;

public class Robot {

    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};

    public int solution(String[] board) {
        char[][] map = new char[board.length][board[0].length()];
        int[] start = new int[3];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < board[0].length(); j++) {
                if (map[i][j] == 'R') {
                    start[0] = j;
                    start[1] = i;
                    start[2] = 0;
                }
            }
        }

        int answer = count(start, map);
        return answer;
    }

    private int count(int[] start, char[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[1]][start[0]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (map[now[1]][now[0]] == 'G') {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int x = now[0];
                int y = now[1];
                while (true) {
                    x += dx[i];
                    y += dy[i];

                    if (x < 0 || y < 0 || x >= map[0].length || y >= map.length || map[y][x] == 'D' ) {
                        x -= dx[i];
                        y -= dy[i];
                        break;
                    }
                }

                if (visited[y][x]) {
                    continue;
                }

                queue.add(new int[]{x, y, now[2] + 1});
                visited[y][x] = true;
            }
        }
        return -1;
    }
}
