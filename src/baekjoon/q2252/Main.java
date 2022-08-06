package baekjoon.q2252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            adjList.get(S).add(E);
            inDegree[E]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int next : adjList.get(now)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
