package baekjoon.q11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, A, visited);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int v, ArrayList<Integer>[] A, boolean[] visited) {

        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (int i : A[v]) {
            if (visited[i] == false) {
                DFS(i, A, visited);
            }
        }
    }
}
