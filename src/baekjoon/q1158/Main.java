package baekjoon.q1158;

import java.util.*;

public class Main {

    static int N, K;
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        K = sc.nextInt();
        queue = new LinkedList<>();
        sb.append("<");

        initQueue();

        while (!queue.isEmpty()) {
            removeKthElement();
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }

    public static void initQueue() {
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
    }

    public static void removeKthElement() {
        for (int i = 0; i < K - 1; i++) {
            queue.add(queue.poll());
        }

        sb.append(queue.poll()).append(", ");
    }
}
