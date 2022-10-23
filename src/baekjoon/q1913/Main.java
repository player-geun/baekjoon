package baekjoon.q1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int[][] pos = new int[N][N];
        int[] d = {1, 1, 2, 2};
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int k = 1;

        int x = N / 2;
        int y = N / 2;

        pos[x][y] = k;
        boolean isEnd = false;

        while (N * N > k) {
            for (int i = 0; i < 4; i++) {
                if (isEnd) {
                    break;
                }
                for (int j = 0; j < d[i]; j++) {
                    x = x + dx[i];
                    y = y + dy[i];
                    if(x < 0 || y <0 || x >= N || y >= N) {
                        isEnd = true;
                        break;
                    }
                    pos[x][y] = ++k;
                }
                d[i] += 2;
            }
        }

        int resultX = 0;
        int resultY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (num == pos[i][j]) {
                    resultX = i + 1;
                    resultY = j + 1;
                }
                sb.append(pos[i][j] + " ");
            }
            sb.append("\n");
        }

        sb.append(resultX).append(" ").append(resultY);

        System.out.println(sb);
    }
}
