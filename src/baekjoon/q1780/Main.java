package baekjoon.q1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] pos;
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        pos = new int[N][N];

        a = 0;
        b = 0;
        c = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        sb.append(a).append("\n");
        sb.append(b).append("\n");
        sb.append(c).append("\n");

        System.out.println(sb);
    }

    static void partition(int x, int y, int N) {
        if (check(x, y, N)) {
            if (pos[x][y] == -1) {
                a++;
            } else if (pos[x][y] == 0) {
                b++;
            } else {
                c++;
            }

            return;
        }

        int newN = N / 3;

        partition(x, y, newN);
        partition(x, y + N / 3, newN);
        partition(x, y + N * 2 / 3, newN);

        partition(x + N / 3, y, newN);
        partition(x + N / 3, y + N / 3, newN);
        partition(x + N / 3, y + N * 2 / 3, newN);

        partition(x + N * 2 / 3, y, newN);
        partition(x + N * 2 / 3, y + N / 3, newN);
        partition(x + N * 2 / 3, y + N * 2 / 3, newN);
    }

    static boolean check(int x, int y, int N) {
        int start = pos[x][y];

        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (start != pos[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
