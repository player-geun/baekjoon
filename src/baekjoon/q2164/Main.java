package baekjoon.q2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {

            queue.offer(i);
        }

        while (queue.size() > 1) {

            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
