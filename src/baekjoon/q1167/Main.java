package baekjoon.q1167;

import java.util.*;

public class Main {

    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 노드의 개수
        int V = sc.nextInt();

        // static 변수 초기화
        A = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접리스트 초기화
        for (int i = 1; i < V + 1; i++) {
            int a = sc.nextInt();

            while (true) {
                int b = sc.nextInt();
                if (b == -1) {
                    break;
                }
                int e = sc.nextInt();

                A[a].add(new Node(b, e));
            }
        }

        // 임의의 시작점에서 BFS 실행하여 distance 배열 생성
        BFS(1);

        // distance 배열에서 가장 큰 값으로 다시 시작점 설정
        int max = 1;
        for (int i = 2; i < V + 1; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];

        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    static void BFS(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] =true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node a : A[now]) {
                if (!visited[a.value]) {
                    visited[a.value] = true;
                    queue.add(a.value);
                    distance[a.value] = distance[now] + a.weight;
                }
            }
        }
    }

    static class Node {

        int value;
        int weight;

        Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
