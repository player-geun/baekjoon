package baekjoon.q11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int n = in.nextInt();
        int seq = in.nextInt();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        sb.append("<");

        while (queue.size() > 0) {

            for (int i = 0; i < seq - 1; i++) {

                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(",").append(" ");
        }

        sb.deleteCharAt(sb.lastIndexOf(" ")).deleteCharAt(sb.lastIndexOf(",")).append(">");

        System.out.println(sb);
    }
}
