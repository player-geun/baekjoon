package baekjoon.q1966;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();

        while (n > 0) {

            int N = in.nextInt();
            int seq = in.nextInt();

            LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                queue.offer(new int[] {i, in.nextInt()});
            }

            int result = 0;

            while (!queue.isEmpty()) {

                int[] front = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {

                    if (front[1] < queue.get(i)[1]) {

                        queue.offer(front);
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if (isMax == false) {
                    continue;
                }

                result++;
                if (front[0] == seq) {
                    break;
                }
            }

            sb.append(result).append("\n");
            n--;
        }

        System.out.println(sb);
    }
}
