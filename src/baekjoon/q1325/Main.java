package baekjoon.q1325;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] adjList;
    // boolean 말고 Boolean으로 사용시 초기화때 null
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();
        adjList = new ArrayList[N + 1];
        depth = new int[N + 1];

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 채우기
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            adjList[A].add(B);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;
        for (int d : depth) {
            if (max < d) {
                max = d;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (depth[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void BFS(int node) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : adjList[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    depth[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
