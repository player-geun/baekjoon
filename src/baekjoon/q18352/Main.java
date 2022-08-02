package baekjoon.q18352;

import java.util.*;

public class Main {

    private static ArrayList<Integer>[] A;
    private static int[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();
        A = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 단방향 그래프이기 때문에 한번만 삽입
            A[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X);

        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    public static void BFS(int node) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : A[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
