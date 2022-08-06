package baekjoon.q11725;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            adjList[A].add(B);
            adjList[B].add(A);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int node) {

        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int i : adjList[node]) {
            if (!visited[i]) {
                DFS(i);
            }

            parent[i] = node;
        }
    }
}
