package baekjoon.q1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(DFS(B, A, C));
    }

    public static long DFS(int B, int A, int C) {
        if (B == 0) {
            return 1;
        }

        long n = DFS(B / 2, A, C);
        if (B % 2 == 0) {
            return n * n % C;
        }

        return (n * n % C) * A % C;
    }
}
