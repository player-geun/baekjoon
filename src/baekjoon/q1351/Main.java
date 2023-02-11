package baekjoon.q1351;

import java.util.*;

public class Main {

    static long N, P, Q;
    static Map<Long, Long> dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        dp = new HashMap<>();
        dp.put(0L, 1L);

        findResult(N);

        System.out.println(dp.get(N));
    }

    public static long findResult(long number) {
        if (dp.containsKey(number)) {
            return dp.get(number);
        }

        dp.put(number, findResult(number / Q) + findResult(number / P));

        return dp.get(number);
    }
}
