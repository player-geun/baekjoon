package baekjoon.q11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<City>> cities;
    private static int[] distances;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        cities = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            cities.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            cities.get(start).add(new City(end, edge));
        }

        for (int i = 1; i <= n; i++) {
            createDistances(i, n);

            for (int j = 1; j <= n; j++) {
                System.out.print((distances[j] == Integer.MAX_VALUE ? 0 : distances[j]) + " ");
            }
            System.out.println();
        }
    }

    public static void createDistances(int start, int n) {
        visited = new boolean[n + 1];
        distances = new int[n + 1];
        PriorityQueue<City> queue = new PriorityQueue<>();

        Arrays.fill(distances, Integer.MAX_VALUE);

        queue.add(new City(start, 0));
        distances[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll().end;

            for (City next : cities.get(now)) {
                if (distances[next.end] > distances[now] + next.edge) {
                    distances[next.end] = distances[now] + next.edge;

                    queue.add(new City(next.end, distances[next.end]));
                }
            }
        }
    }

    public static class City implements Comparable<City> {

        private int end;
        private int edge;

        public City(int end, int edge) {
            this.end = end;
            this.edge = edge;
        }

        @Override
        public int compareTo(City o) {
            return this.edge - o.edge;
        }
    }
}
