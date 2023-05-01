package baekjoon.q6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean check = false;

            for (int i = x; i < (N * M); i += M) {
                if (i % N == 0 ? N == y : i % N == y) {
                    System.out.println(i);
                    check = true;
                    break;
                }
            }

            if (!check) {
                System.out.println(-1);

            }
        }
    }
}
