package baekjoon.programmers;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {

    public static void main(String[] args) {
        int n = 2;
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        System.out.println(process.toArray(new int[0][]));
    }

    private static void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, empty, process);
        hanoi(n - 1, from, empty, process);
    }

}
