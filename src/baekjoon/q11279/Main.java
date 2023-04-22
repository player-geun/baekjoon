package baekjoon.q11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (isZero(queue, input)) continue;

            if (isEmpty(sb, queue)) continue;

            sb.append(queue.poll()).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isEmpty(StringBuilder sb, PriorityQueue<Integer> queue) {
        if (queue.isEmpty()) {
            sb.append(0).append("\n");
            return true;
        }
        return false;
    }

    private static boolean isZero(PriorityQueue<Integer> queue, int input) {
        if (input != 0) {
            queue.add(input);
            return true;
        }
        return false;
    }
}
