package baekjoon.q1516;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        int[] selfBuild = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            selfBuild[i] = sc.nextInt();

            while (true) {
                int preTemp = sc.nextInt();

                if (preTemp == -1) {
                    break;
                }

                adjList.get(preTemp).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : adjList.get(now)) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
