package baekjoon.q14391;

import java.util.*;

public class Main {

    static int N, M, maxSum;
    static Paper[][] papers;
    static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        papers = new Paper[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                papers[i][j] = new Paper(2, line.charAt(j) - '0');
            }
        }

        selectAllPaperStatus(0);

        System.out.println(maxSum);
    }

    public static void selectAllPaperStatus(int count) {
        if (count == N * M) {
            calculateSumOfPapers();
            return;
        }

        //가로 선택
        papers[count / M][count % M].changeStatus(0);
        selectAllPaperStatus(count + 1);
        //세로 선택
        papers[count / M][count % M].changeStatus(1);
        selectAllPaperStatus(count + 1);
    }

    public static void calculateSumOfPapers() {
        isVisited = new boolean[N][M];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    if (papers[i][j].status == 0) {
                        sum += addWidth(i, j);
                    } else {
                        sum += addHeight(i, j);
                    }
                }
            }
        }

        maxSum = Math.max(maxSum, sum);
    }

    public static int addWidth(int y, int x) {
        int sum = 0;

        while (true) {
            sum = sum * 10 + papers[y][x].value;
            isVisited[y][x] = true;

            x += 1;

            if (x >= M) {
                return sum;
            }

            if (isVisited[y][x] || papers[y][x].status == 1) {
                return sum;
            }
        }
    }

    public static int addHeight(int y, int x) {
        int sum = 0;

        while (true) {
            sum = sum * 10 + papers[y][x].value;
            isVisited[y][x] = true;

            y += 1;

            if (y >= N) {
                return sum;
            }

            if (isVisited[y][x] || papers[y][x].status == 0) {
                return sum;
            }
        }
    }

    public static class Paper {

        private int status;     // 가로 : 0, 세로 : 1
        private int value;

        public Paper(int status, int value) {
            this.status = status;
            this.value = value;
        }

        public void changeStatus(int status) {
            this.status = status;
        }
    }
}
