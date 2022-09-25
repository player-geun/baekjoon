package baekjoon.q1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] pos;
   static int N;
   static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pos = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                pos[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }

    static void partition(int x, int y, int size) {
        if (check(x, y, size)) {
            if (pos[x][y] == 1) {
                sb.append(1);
                return;
            } else {
                sb.append(0);
                return;
            }
        }

        sb.append("(");

        int newSize = size / 2;
        partition(x, y, newSize);
        partition(x, y + newSize, newSize);
        partition(x + newSize, y, newSize);
        partition(x + newSize, y + newSize, newSize);

        sb.append(")");
    }

    static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (pos[x][y] != pos[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
