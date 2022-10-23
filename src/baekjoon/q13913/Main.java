package baekjoon.q13913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N, K;
    static int[] pos;
    static boolean[] visited;
    static int[] dx = {1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        K = sc.nextInt();
        pos = new int[100001];
        visited = new boolean[100001];

        System.out.println(BFS());

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(pos[index]);
            index = pos[index];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]] = true;

            if (now[0] == K) {
                return now[1];
            }

            for (int k = 0; k < 2; k++) {
                int x = now[0] + dx[k];

                if (x >= 0 && x <= 100000) {
                    if (!visited[x]) {
                        queue.add(new int[]{x, now[1] + 1});
                        visited[x] = true;
                        pos[x] = now[0];
                    }
                }
            }

            int x = now[0] * 2;

            if (x >= 0 && x <= 100000) {
                if (!visited[x]) {
                    queue.add(new int[]{x, now[1] + 1});
                    visited[x] = true;
                    pos[x] = now[0];
                }
            }
        }

        return 0;
    }
}
