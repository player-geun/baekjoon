package baekjoon.q2606;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            adjList[A].add(B);
            adjList[B].add(A);
        }

        DFS(1);

        int result = 0;
        for (boolean i : visited) {
            if (i == true) {
                result++;
            }
        }

        System.out.println(result - 1);
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
        }
    }
}
