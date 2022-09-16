package baekjoon.q11729;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        recH(N, 1, 2, 3);
        System.out.println(sb);
    }

    static void recH(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        recH(N - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        recH(N - 1, mid, start, to);
    }
}
