package baekjoon.q14500;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(Math.max(Math.max(Math.max(A(), B()), Math.max(C(), D())), E()));
    }

    // 정사각형
    static int A() {
        int max = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max < map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1]) {
                    max = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
                }
            }
        }

        return max;
    }

    // 직사각형
    static int B() {
        int max1 = 0;
        int max2 = 0;
        // 가로로 길때
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 3; j++) {
                if (max1 < map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3]) {
                    max1 = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
                }
            }
        }
        //세로로 길때
        for (int i = 0; i < N - 3; i++) {
            for (int j = 0; j < M; j++) {
                if (max2 < map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j]) {
                    max2 = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
                }
            }
        }

        return Math.max(max1, max2);
    }

    // 엿
    static int C() {
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;
        // 위
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max1 < map[i + 1][j] + map[i][j + 1] + map[i+ 1][j + 1] + map[i + 1][j + 2]) {
                    max1 = map[i + 1][j] + map[i][j + 1] + map[i+ 1][j + 1] + map[i + 1][j + 2];
                }
            }
        }
        //아래
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max2 < map[i][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2]) {
                    max2 = map[i][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
                }
            }
        }
        // 오른쪽
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max3 < map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1]) {
                    max3 =  map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
                }
            }
        }
        //왼쪽
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max4 < map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i + 2][j + 1]) {
                    max4 = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i + 2][j + 1];
                }
            }
        }

        return Math.max(Math.max(max1, max2), Math.max(max3, max4));
    }

    static int D() {
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;
        // 경우 1
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max1 < map[i][j] + map[i + 1][j] + map[i+ 1][j + 1] + map[i + 2][j + 1]) {
                    max1 = map[i][j] + map[i + 1][j] + map[i+ 1][j + 1] + map[i + 2][j + 1];
                }
            }
        }
        // 경우 1 대칭
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max2 < map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j]) {
                    max2 = map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j];
                }
            }
        }
        // 경우 2
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max3 < map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2]) {
                    max3 =  map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
                }
            }
        }
        //왼쪽
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max4 < map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2]) {
                    max4 = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
                }
            }
        }

        return Math.max(Math.max(max1, max2), Math.max(max3, max4));
    }

    static int E() {
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;
        int max5 = 0;
        int max6 = 0;
        int max7 = 0;
        int max8 = 0;
        // 경우 1
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max1 < map[i][j] + map[i][j+ 1] + map[i+ 1][j + 1] + map[i + 2][j + 1]) {
                    max1 = map[i][j] + map[i][j+ 1] + map[i+ 1][j + 1] + map[i + 2][j + 1];
                }
            }
        }
        // 경우 1 대칭
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max2 < map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1]) {
                    max2 = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1];
                }
            }
        }
        // 경우 2
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max3 < map[i + 2][j] + map[i][j+ 1] + map[i+ 1][j + 1] + map[i + 2][j + 1]) {
                    max3 = map[i + 2][j] + map[i][j+ 1] + map[i+ 1][j + 1] + map[i + 2][j + 1];
                }
            }
        }
        // 경우 2 대칭
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (max4 < map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1]) {
                    max4 = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
                }
            }
        }
        // 경우 3
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max5 < map[i][j] + map[i + 1][j] + map[i+ 1][j + 1] + map[i + 1][j + 2]) {
                    max5 = map[i][j] + map[i + 1][j] + map[i+ 1][j + 1] + map[i + 1][j + 2];
                }
            }
        }
        // 경우 3 대칭
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max6 < map[i][j + 2] + map[i + 1][j] + map[i+ 1][j + 1] + map[i + 1][j + 2]) {
                    max6 = map[i][j + 2] + map[i + 1][j] + map[i+ 1][j + 1] + map[i + 1][j + 2];
                }
            }
        }
        // 경우 4
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max7 < map[i][j] + map[i][j+ 1] + map[i][j + 2] + map[i + 1][j]) {
                    max7 = map[i][j] + map[i][j+ 1] + map[i][j + 2] + map[i + 1][j];
                }
            }
        }
        // 경우 4 대칭
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (max8 < map[i][j] + map[i][j+ 1] + map[i][j + 2] + map[i + 1][j + 2]) {
                    max8 = map[i][j] + map[i][j+ 1] + map[i][j + 2] + map[i + 1][j + 2];
                }
            }
        }

        return Math.max(Math.max(Math.max(max1, max2), Math.max(max3, max4)), Math.max(Math.max(max5, max6), Math.max(max7, max8)));
    }
}
