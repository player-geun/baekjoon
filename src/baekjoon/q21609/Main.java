package baekjoon.q21609;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] gameBoard;
    static boolean[][] isVisited;
    static Queue<Group> bigBlockGroupCandidates;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gameBoard = new int[N][N];
        bigBlockGroupCandidates = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                gameBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            makeBigBlockGroup();    // BigGroup 만듬

            //BigGroup이 정상적인지 판단 -> 유효하지 않으면 break;

            //오토 게임 플레이
        }

    }

    public static void makeBigBlockGroup() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (gameBoard[i][j] >= 0) {
                    BFS(i, j);
                }
            }
        }
    }

    public static void BFS(int y, int x) {
        Queue<Group> queue = new LinkedList<>();
        isVisited = new boolean[N][N];

        int normalBlockNumber = -3;
        int normalBlockCount = 0;
        int size = 1;
        if (gameBoard[y][x] > 0) {
            normalBlockNumber = gameBoard[y][x];
            normalBlockCount = 1;
        }

        queue.add(new Group(y, x, normalBlockNumber, normalBlockCount, size));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            Group now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now.currentY + dy[i];
                int nextX = now.currentX + dx[i];

                if (nextX >= N || nextY >= N || nextX < 0 || nextY < 0) {
                    continue;
                }

                if (gameBoard[nextY][nextX] < 0 || isVisited[nextY][nextX]) {
                    continue;
                }

                if (gameBoard[nextY][nextX] == normalBlockNumber) {
                    queue.add(new Group(nextY, nextX, now.normalBlockNumber, now.normalBlockCount++, now.size++));
                    isVisited[nextY][nextX] = true;
                } else if (now.normalBlockNumber < 0 && gameBoard[nextY][nextX] > 0) {
                    queue.add(new Group(nextY, nextX, gameBoard[nextY][nextX], now.normalBlockCount++, now.size++));
                    isVisited[nextY][nextX] = true;
                } else {
                    queue.add(new Group(nextY, nextX, now.normalBlockNumber, now.normalBlockCount, now.size++));
                    isVisited[nextY][nextX] = true;
                }
            }
        }

        return;
    }

    public static class Group {

        private int currentY;
        private int currentX;
        private int normalBlockNumber;
        private int normalBlockCount;
        private int size;

        public Group(int currentY, int currentX, int normalBlockNumber, int normalBlockCount, int size) {
            this.currentY = currentY;
            this.currentX = currentX;
            this.normalBlockNumber = normalBlockNumber;
            this.normalBlockCount = normalBlockCount;
            this.size = size;
        }
    }
}
