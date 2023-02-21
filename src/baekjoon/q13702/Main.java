package baekjoon.q13702;

import java.util.*;

public class Main {

    static int N, K;
    static int[] kettles;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        kettles = new int[N];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            kettles[i] = sc.nextInt();
            max = Math.max(max, kettles[i]);
        }

        System.out.println(findMaxAmount(0, max));


    }

    // 이분탐색
    public static int findMaxAmount(int left, int right) {
        int result = 0;
        while (left <= right) {
            int mid = (left / 2 + right / 2);

            if (isOk(mid)) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isOk(int mid) {
        int sum = 0;
        for (int amount : kettles) {
            sum += (amount / mid);
        }

        return sum < K;
    }
}
