package baekjoon.q1260;

import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 노드 개수, 에지 개수, 시작점
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        // 인접 리스트 초기화
        A = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접 리스트에 에지 연결(양방향 연결)
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            A[a].add(b);
            A[b].add(a);
        }

        // 작은 수 부터 출력하기 위해 정렬
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(A[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        //BFS
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }

    static void DFS(int v) {

        System.out.print(v + " ");
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
