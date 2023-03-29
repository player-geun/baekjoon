package baekjoon.q2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int width, height, timeOfMinLengthToFar;
    static char[][] treasureMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        sc.nextLine();
        treasureMap = new char[height][width];

        for (int i = 0; i < height; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < width; j++) {
                treasureMap[i][j] = line.charAt(j);
            }
        }

        findTimeOfMinLengthToFar();

        System.out.println(timeOfMinLengthToFar);
    }

    public static void findTimeOfMinLengthToFar() {
        // 모든 점에 대해서 가장 먼 최단 거리 시간 구하기
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (treasureMap[i][j] == 'L') {
                    // 가장 먼 최단 거리 탐색
                    isVisited = new boolean[height][width];
                    calculateTimeToBfs(i, j);
                }
            }
        }
    }


    public static void calculateTimeToBfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        isVisited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                timeOfMinLengthToFar = Math.max(timeOfMinLengthToFar, now[2]);

                if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
                    continue;
                }

                if (treasureMap[nextY][nextX] == 'W' || isVisited[nextY][nextX]) {
                    continue;
                }

                isVisited[nextY][nextX] = true;
                queue.add(new int[]{nextY, nextX, now[2] + 1});
            }
        }
    }
}
