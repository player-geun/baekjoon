package baekjoon.q15649;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, used;

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
        used = new int[N + 1];
    }

    public static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (used[i] == 1) {
                    continue;
                }
                selected[k] = i;
                used[i] = 1;
                recFunc(k + 1);
                selected[k] = 0;
                used[i] = 0;
            }
        }
    }
}
