package baekjoon.q3190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, K, L, playTime, currentDirection, length;
    static boolean isPlaying;
    static int[] tail;
    static Queue<int[]> log;
    static int[][] board;
    static Queue<Direction> directions;
    static int[] dx = {0, 0, -1, 1};    // 우, 좌, 상, 하
    static int[] dy = {1, -1, 0, 0};
    static int RIGHT = 0;
    static int LEFT = 1;
    static int UP = 2;
    static int DOWN = 3;
    static int APPLE = 10;
    static int SNAKE = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        board = new int[N][N];
        tail = new int[2];
        log = new LinkedList<>();
        board[0][0] = SNAKE;

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            board[x][y] = APPLE;
        }

        L = sc.nextInt();
        directions = new LinkedList<>();
        length = 1;
        playTime = 0;
        isPlaying = true;

        for (int i = 0; i < L; i++) {
            int time = sc.nextInt();
            String direction = sc.next();

            if (direction.equals("D")) {
                directions.add(new Direction(time, RIGHT));
            } else {
                directions.add(new Direction(time, LEFT));
            }
        }

        playGame(0, 0);

        System.out.println(playTime);
    }

    public static void playGame(int currentX, int currentY) {
        while (isPlaying) {
            int[] next = move(new int[]{currentX, currentY}, currentDirection);
            currentX = next[0];
            currentY = next[1];

            changeDirection();
        }
    }

    public static boolean verifyGameRule(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        } else if (board[x][y] == SNAKE) {
            if (x == 0 && y == 0) {
                return true;
            }
            return false;
        }

        return true;
    }

    public static int[] move(int[] now, int direction) {
        int nextX = now[0] + dx[direction];
        int nextY = now[1] + dy[direction];

        log.add(new int[]{nextX, nextY});
        playTime++;

        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
            isPlaying = false;
            return new int[]{nextX, nextY};
        }

        if (board[nextX][nextY] == SNAKE) {
            isPlaying = false;
        }

        if (board[nextX][nextY] == APPLE) {
            board[nextX][nextY] = SNAKE;
        } else {
            board[nextX][nextY] = SNAKE;
            board[tail[0]][tail[1]] = 0;
            int[] temp = log.poll();
            tail[0] = temp[0];
            tail[1] = temp[1];
        }

        return new int[]{nextX, nextY};
    }

    public static void changeDirection() {
        if (directions.isEmpty()) {
            return;
        }

        Direction direction = directions.peek();
        if (direction.time == playTime) {

            if (direction.direction == RIGHT) {
                if (currentDirection == RIGHT) {
                    currentDirection = DOWN;
                } else if (currentDirection == LEFT) {
                    currentDirection = UP;
                } else if (currentDirection == UP) {
                    currentDirection = RIGHT;
                } else if (currentDirection == DOWN) {
                    currentDirection = LEFT;
                }
            } else {
                if (currentDirection == RIGHT) {
                    currentDirection = UP;
                } else if (currentDirection == LEFT) {
                    currentDirection = DOWN;
                } else if (currentDirection == UP) {
                    currentDirection = LEFT;
                } else if (currentDirection == DOWN) {
                    currentDirection = RIGHT;
                }
            }

            directions.poll();
        }
    }

    public static class Direction {

        private int time;
        private int direction;

        public Direction(int time, int direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
