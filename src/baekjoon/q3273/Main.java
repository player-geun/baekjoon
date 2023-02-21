package baekjoon.q3273;

import java.util.*;

public class Main {

    static int n, x, count;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = sc.nextInt();
        }

        x = sc.nextInt();

        countSumOfX();

        System.out.println(count);
    }

    public static void countSumOfX() {
        Arrays.sort(numbers, 1, n + 1);

        for (int i = 1; i < n; i++) {
            if (x - numbers[i] > 0) {
                if (upperBound(i + 1, n, x - numbers[i])) {
                    count++;
                }
            }
        }
    }

    public static boolean upperBound(int left, int right, int answer) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (numbers[mid] < answer) {
                left = mid + 1;
            } else if (numbers[mid] > answer) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
