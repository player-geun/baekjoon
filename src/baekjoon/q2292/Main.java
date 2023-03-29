package baekjoon.q2292;

import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //각각의 범위에 N이 들어가는지 보고 안들어가면 범위를 늘린다.
        System.out.println(calculateMinLength());
    }

    public static int calculateMinLength() {
        long before = 1;
        long after = 2;
        int minLength = 1;

        while (after <= 10000000000L) {
            if (before <= N && after - 1 >= N) {
                return minLength;
            } else {
                before = after;
                after = before + 6 * minLength;
                minLength++;
            }
        }

        return -1;
    }
}
