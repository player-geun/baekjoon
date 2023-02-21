package baekjoon.q16435;

import java.util.*;

public class Main {

    static int N, L;
    static int[] apples;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        apples = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            apples[i] = sc.nextInt();
        }

        Arrays.sort(apples, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            if (L >= apples[i]) {
                L++;
            }
        }

        System.out.println(L);
    }
}
