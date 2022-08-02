package baekjoon.q1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] set;
    static boolean isEven;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        while(K-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            adjList = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            set = new int[V + 1];

            // 인접리스트 노드 생성
            for (int i = 0; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            // 인접 리스트에 엣지 정보 삽입
            for (int i = 0; i < E; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                adjList[A].add(B);
                adjList[B].add(A);
            }

            isEven = true;
            for (int i = 1; i <= V; i++) {
                if (isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int node) {

        visited[node] = true;

        for (int i : adjList[node]) {
            if (!visited[i]) {
                set[i] = (set[node] + 1) % 2;
                DFS(i);
            } else if (set[node] == set[i]) {
                isEven = false;
            }
        }
    }
}
