package baekjoon.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
알고리즘 프로그래밍 과제6
2018125039 이근우
 */
public class HW6 {

    static int N, M, s, a ,b, result;
    static int[] distance;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        input();
        bellmanFord();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        result = 0;
        edges = new Edge[M];
        distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, weight);
        }
    }

    public static void bellmanFord() {
        distance[s] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.weight) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }

        result += distance[a];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[a] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.weight) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }

        result += distance[b];
    }

    public static void output() {
        System.out.println(result);
    }

    static class Edge {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
