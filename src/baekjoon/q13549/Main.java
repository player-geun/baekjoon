package baekjoon.q13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] pos;
    static boolean[] visited;
    static int[] dx = {1, -1};
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[100001];
        visited = new boolean[100001];

        System.out.println(BFS());
    }

    static int BFS() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.n] = true;

            if (now.n == K) {
                return now.t;
            }

            int x = now.n * 2;

            if (x >= 0 && x <= 100000 && !visited[x]) {
                queue.add(new Node(x, now.t));
                visited[x] = true;
            }

            for (int k = 0; k < 2; k++) {
                x = now.n + dx[k];

                if (x >= 0 && x <= 100000 && !visited[x]) {
                    queue.add(new Node(x, now.t + 1));
                    visited[x] = true;
                }
            }
        }

        return 0;
    }

    static class Node implements Comparable<Node>{

        int n;
        int t;

        Node(int n, int t) {
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }
}
