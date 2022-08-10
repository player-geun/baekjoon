package baekjoon.q1948;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<dNode>> A = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            int V = sc.nextInt();

            A.get(S).add(new dNode(E, V));
            reverseA.get(E).add(new dNode(S, V));   // 역방향 에지 정보 저장
            inDegree[E]++;                          // 진입 차수 배열 초기화
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N + 1];

        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (dNode next : A.get(now)) {
                inDegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);

                if (inDegree[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }

        // 위상 정렬 Reverse
        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();

        queue.offer(end);
        visited[end] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (dNode next : reverseA.get(now)) {
                // 1분도 쉬지 않는 도로 체크
                if (result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    // 중복 카운트 방지를 위해 이미 방문학 적이 있는 노드 제외
                    if (visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }

        System.out.println(result[end]);
        System.out.println(resultCount);
    }

    static class dNode {

        int targetNode;
        int value;

        dNode(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
