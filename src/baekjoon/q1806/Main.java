package baekjoon.q1806;

import java.util.*;

public class Main {

    static int N, S;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
        }

        int length = findMinLengthSum();

        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(length);
        }
    }

    public static int findMinLengthSum() {
        // 투포인터
        int left = 1;
        int right = 1;
        int length = Integer.MAX_VALUE;

        while (left <= N && right <= N) {
            int sum = sumLeftToRight(left, right);
            if (sum >= S) {
                length = Math.min(length, right - left + 1);
                left++;
            } else {
                right++;
            }
        }

        return length;
    }

    public static int sumLeftToRight(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}
