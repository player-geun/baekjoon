package baekjoon.q10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int T, n, d, c, time;
    static ArrayList<Edge>[] list;
    static int[] distance;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();
            dijkstra();
            output();
        }
    }

    public static void input() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list[b].add(new Edge(a, s));
        }
    }

    public static void dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(c, 0));
        distance[c] = 0;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int nowVertex = now.vertex;

            if(visited[nowVertex]) continue;

            visited[nowVertex] = true;
            time = now.value;

            for (int i = 0; i < list[nowVertex].size(); i++) {
                Edge temp = list[nowVertex].get(i);
                int next = temp.vertex;
                int value = temp.value;

                if (distance[next] > distance[nowVertex] + value) {
                    distance[next] = distance[nowVertex] + value;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
    }

    public static void output() {
        int com = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                com ++;
            }
        }

        System.out.println(com + " " + time);
    }

    static class Edge implements Comparable<Edge>{
        private int vertex;
        private int value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
