package baekjoon.q12886;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if (canSameCount(new Stone(A, B, C))) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean canSameCount(Stone stone) {
        boolean[][] visited = new boolean[1501][1501];
        Queue<Stone> queue = new LinkedList<>();
        queue.add(stone);
        visited[stone.a][stone.b] = true;

        while (!queue.isEmpty()) {
            Stone now = queue.poll();
            if (now.a == now.b && now.b == now.c) {
                return true;
            }

            if (now.a != now.b) {
                int a, b;
                if (now.a > now.b) {
                    a = now.a - now.b;
                    b = now.b * 2;
                } else {
                    a = now.a * 2;
                    b = now.b - now.a;
                }

                if (!visited[a][b]) {
                    visited[a][b] = true;
                    queue.add(new Stone(a, b, now.c));
                }
            }

            if (now.a != now.c) {
                int a, c;
                if (now.a > now.c) {
                    a = now.a - now.c;
                    c = now.c * 2;
                } else {
                    a = now.a * 2;
                    c = now.c - now.a;
                }

                if (!visited[a][now.b]) {
                    visited[a][now.b] = true;
                    queue.add(new Stone(a, now.b, c));
                }
            }

            if (now.b != now.c) {
                int b, c;
                if (now.b > now.c) {
                    b = now.b - now.c;
                    c = now.c * 2;
                } else {
                    b = now.b * 2;
                    c = now.c - now.b;
                }

                if (!visited[now.a][b]) {
                    visited[now.a][b] = true;
                    queue.add(new Stone(now.a, b, c));
                }
            }
        }
        return false;
    }

    public static class Stone {
        private int a;
        private int b;
        private int c;

        public Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
