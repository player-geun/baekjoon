package baekjoon.q15650;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb);
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M + 1];
    }

    public static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = selected[k - 1] + 1; i <= N; i++) {
                selected[k] = i;
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }
}
