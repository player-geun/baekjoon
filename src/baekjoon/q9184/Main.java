package baekjoon.q9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] threeDimArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        threeDimArray = new int[21][21][21];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            sb.append(dp(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    static int dp(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp(20, 20, 20);
        }

        if (a < b && b < c) {
            if (threeDimArray[a][b][c] != 0) {
                return threeDimArray[a][b][c];
            }
            threeDimArray[a][b][c] = dp(a, b, c - 1) + dp(a, b - 1, c - 1) - dp(a, b - 1, c);
            return threeDimArray[a][b][c];
        }

        if (threeDimArray[a][b][c] != 0) {
            return threeDimArray[a][b][c];
        }
        threeDimArray[a][b][c] = dp(a - 1, b, c) + dp(a - 1, b - 1, c)
                + dp(a - 1, b, c - 1) - dp(a - 1, b - 1, c - 1);

        return threeDimArray[a][b][c];
    }
}
