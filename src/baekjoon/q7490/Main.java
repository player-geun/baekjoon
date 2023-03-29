package baekjoon.q7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final String[] ex = {" ", "+", "-"};
    private static int max;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            max = Integer.parseInt(br.readLine());
            makeNumericalExpression(1, "");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean validateZero(String numericalExpression) {
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Character> operations = new LinkedList<>();
        makeQueue(numericalExpression, numbers, operations);

        int result = numbers.poll();

        result = calculateResult(numbers, operations, result);

        if (result == 0) {
            return true;
        }

        return false;
    }

    private static int calculateResult(Queue<Integer> numbers, Queue<Character> operations, int result) {
        while (!operations.isEmpty()) {
            int secondNum = numbers.poll();

            if (operations.poll() == '+') {
                result += secondNum;
            } else {
                result -= secondNum;
            }
        }
        return result;
    }

    private static void makeQueue(String numericalExpression, Queue<Integer> numbers, Queue<Character> operations) {
        int sum = 0;

        int len = numericalExpression.length();
        for (int i = 0; i < len; i++) {
            char c = numericalExpression.charAt(i);
            if (c < '0' || c > '9') {
                if (c == ' ') {
                    sum = sum * 10;
                    continue;
                }

                numbers.add(sum);
                sum = 0;
                operations.add(c);
                continue;
            }

            sum += c - '0';

            if (i == len - 1) {
                numbers.add(sum);
            }
        }
    }

    public static void makeNumericalExpression(int num, String numericalExpression) {
        numericalExpression += num;

        if (num == max) {
            if (validateZero(numericalExpression)) {
                sb.append(numericalExpression).append("\n");
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            makeNumericalExpression(num + 1, numericalExpression + ex[i]);
        }
    }
}
