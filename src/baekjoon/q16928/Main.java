package baekjoon.q16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int LAST_NUMBER = 100;
    private static int minCount = Integer.MAX_VALUE;
    private static Map<Integer, Integer> ladders = new HashMap<>();
    private static  Map<Integer, Integer> snakes = new HashMap<>();
    private static int[][] map = new int[100][100];
    private static boolean[][] visited = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int number = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = number++;
            }
        }

        findAll(1, 0);

        System.out.println(minCount);
    }

    public static void findAll(int value, int count) {
        int y = value / 10;
        int x = value % 10;
        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        if (value > LAST_NUMBER) {
            return;
        }

        if (value == 100) {
            minCount = Math.min(minCount, count);
            return;
        }

        if (ladders.containsKey(value)) {
            findAll(ladders.get(value), count + 1);
        }
        if (ladders.containsKey(value)) {
            return;
        }
        findAll(value + 1, count + 1);
        findAll(value + 2, count + 1);
        findAll(value + 3, count + 1);
        findAll(value + 4, count + 1);
        findAll(value + 5, count + 1);
        findAll(value + 6, count + 1);
    }
}
