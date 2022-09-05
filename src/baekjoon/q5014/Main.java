package baekjoon.q5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] map;
    static boolean[] visited;
    static int F, S, G, min;
    static int[] dx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        min = 1;
        dx = new int[]{sc.nextInt(), sc.nextInt() * -1};
        map = new int[F + 1];
        visited = new boolean[F + 1];

        for (int i = 1; i < F + 1; i++) {
            map[i] = 0;
        }

        int result = BFS();

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;

            if (now == G) {
                return map[now];
            }

            for (int i = 0; i < 2; i++) {
                int x = now + dx[i];

                if (x > 0 && x <= F && !visited[x]) {
                    visited[x] = true;
                    map[x] = map[now] + 1;
                    queue.add(x);
                }
            }
        }

        return -1;
    }
}
