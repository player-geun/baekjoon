package baekjoon.q1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = in.nextInt();
        int start = 0;

        for (int i = 0; i < n; i++) {

            int value = in.nextInt();

            if (value > start) {

                for (int j = start + 1; j < value + 1; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = value;
            }
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
