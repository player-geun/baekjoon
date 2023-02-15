package baekjoon.q16926;

import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] board;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 돌리기 -> 끝에 부터 중간까지
        for (int i = 0; i < R; i++) {
            circle(1, 1, N, M);
        }

        for (int j = 1; j <= N; j++) {
            for (int k = 1; k <= M; k++) {
                System.out.print(board[j][k] + " ");
            }
            System.out.println();
        }
    }

    public static void circle(int startN, int startM, int endN, int endM) {
        int x = endM - startM;
        int y = endN - startN;
        if (Math.min(x, y) <= 0) {
            return;
        }

        int temp = board[startN][startM];

        for (int i = startM + 1; i <= endM; i++) {
            board[startN][i - 1] = board[startN][i];
        }

        for (int i = startN + 1; i <= endN; i++) {
            board[i - 1][endM] = board[i][endM];
        }

        for (int i = endM - 1; i >= startM; i--) {
            board[endN][i + 1] = board[endN][i];
        }

        for (int i = endN - 1; i >= startN; i--) {
            board[i + 1][startM] = board[i][startM];
        }

        board[startN + 1][startM] = temp;

        circle(startN + 1, startM + 1, endN - 1, endM - 1);
    }

    public static void move() {

    }
}
