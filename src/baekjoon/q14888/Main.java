package baekjoon.q14888;

import java.util.Scanner;

public class Main {

    static int N, min, max;
    static int[] operators;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        operators = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        findMaxAndMinValue(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void findMaxAndMinValue(int depth, int value) {
        if (depth == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int newValue = calculate(i + 1, value, numbers[depth + 1]);
                findMaxAndMinValue(depth + 1, newValue);
                operators[i]++;
            }
        }
    }

    public static int calculate(int operator, int value1, int value2) {
        if (operator == 1) {
            return value1 + value2;
        } else if (operator == 2) {
            return value1 - value2;
        } else if (operator == 3) {
            return value1 * value2;
        } else {
            return value1 / value2;
        }
    }
}
