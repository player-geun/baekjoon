package baekjoon.q4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        while (!str.equals(".")) {

            System.out.println(validStr(str));
            str = in.nextLine();
        }
    }

    public static String validStr(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '[' || c == '(') {
                stack.push(c);
            } else if (c == ')') {

                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (c == ']') {

                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
