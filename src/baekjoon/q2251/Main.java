package baekjoon.q2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 6가지 이동 케이스를 표현하기 위한 배열
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    // A, B만 있으면 C의 무게가 고정되므로 2개만 체크
    static boolean[][] visited;
    static int[] now;
    static boolean[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        now = new int[3];
        visited = new boolean[201][201];
        answer = new boolean[201];

        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void BFS() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            Node p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;

                if (next[receiver[k]] > now[receiver[k]]) {
                    // 물이 넘칠 때, 초과하는 만큼 다시 이전 물통에 넣어줌
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new Node(next[0], next[1]));

                    // A 물의 양이 0일 때 C의 무게를 정답 변수에 저장
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class Node {

        int A;
        int B;

        Node(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
