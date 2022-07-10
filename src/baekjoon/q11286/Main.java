package baekjoon.q11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> myqueue = new PriorityQueue<>((o1, o2) -> {

            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            } else {
                return firstAbs - secondAbs;
            }
        });

        for (int i = 0; i < N; i++) {

            int request = Integer.parseInt(br.readLine());

            if (request == 0) {
                if (myqueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myqueue.poll());
                }
            } else {
                myqueue.add(request);
            }
        }
    }
}
