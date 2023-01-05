package baekjoon.q1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge>[] list;
    static int[] distance;
    static int N, D;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[10001];
        distance = new int[10001];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < distance.length; i++) {
            distance[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }
    }

    public static void dijkstra() {
        for (int i = 0; i <= D; i++) {
            if (i != 0)
                distance[i] = Math.min(distance[i - 1] + 1, distance[i]);
            if (list[i].size() > 0) {
                for (Edge edge : list[i]) {
                    int val = edge.value;
                    int end = edge.vertex;
                    if (distance[end] > distance[i] + val) {
                        distance[end] = distance[i] + val;
                    }
                }
            }

        }
    }

    public static void output() {
        System.out.println(distance[D]);
    }

    public static class Edge implements Comparable<Edge>{

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
