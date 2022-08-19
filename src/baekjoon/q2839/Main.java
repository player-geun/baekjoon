package baekjoon.q2839;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j < 1700; j++) {
                int num = i * 5 + j * 3;

                if (num > N) {
                    break;
                } else if (num == N) {
                    queue.add(i + j);
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(queue);
            System.out.println(queue.get(0));
        }
    }
}
