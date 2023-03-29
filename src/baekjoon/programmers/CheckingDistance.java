package baekjoon.programmers;

import java.util.*;

public class CheckingDistance {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static ArrayList<Integer> result;
    private static boolean[][] isVisited;

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            char[][] waitingPlaces = new char[5][5];
            for (int j = 0; j < 5; j++) {
                waitingPlaces[j] = places[i][j].toCharArray();
            }

            if (validateDistanceRule(waitingPlaces)) {
                result.add(1);
            } else {
                result.add(0);
            }
        }

        System.out.println();
    }

    public static boolean validateDistanceRule(char[][] waitingPlaces) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (waitingPlaces[i][j] == 'P') {
                    if (!BFS(waitingPlaces, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean BFS(char[][] waitingPlaces, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        isVisited = new boolean[5][5];
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[2] == 2) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newY = now[0] + dy[i];
                int newX = now[1] + dx[i];

                if (newY < 0 || newX < 0 || newY >= 5 || newX >= 5) {
                    continue;
                }

                if (isVisited[newY][newX] || waitingPlaces[newY][newX] == 'X') {
                    continue;
                }

                if (waitingPlaces[newY][newX] == 'P') {
                    return false;
                }

                queue.add(new int[]{newY, newX, now[2] + 1});
                isVisited[newY][newX] = true;
            }
        }

        return true;
    }
}
