package baekjoon.q1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] map;
    static boolean[] visited;
    static int N, K, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[100001];
        visited = new boolean[100001];
        cnt = 0;
        map[N] = 0;

        BFS();

        System.out.println(map[K]);
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;

            for (int k = 0; k < 3; k++) {
                int x = 0;
                if (k == 0) {
                    x = now - 1;
                } else if (k == 1) {
                    x = now + 1;
                } else {
                    x = now * 2;
                }

                if (x >= 0 && x <= 100000) {
                    if (!visited[x]) {
                        visited[x] = true;
                        map[x] = map[now] + 1;
                        queue.add(x);
                    }
                }
            }
        }
    }
}
