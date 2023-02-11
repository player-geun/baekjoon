package baekjoon.q2003;

import java.util.Scanner;

public class Main {

    static int N, count;
    static long M;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextLong();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        findNumberCases();

        System.out.println(count);
    }

    public static void findNumberCases() {
        int left = 0;
        int right = 0;

        while (right < N) {
            int sum = sumLeftToRight(left, right);
            if (sum < M) {
                right++;
            } else if (sum > M) {
                left++;
            } else {
                right++;
                left++;
                count++;
            }
        }
    }

    public static int sumLeftToRight(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}
