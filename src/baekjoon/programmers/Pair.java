package baekjoon.programmers;

import java.util.Stack;

public class Pair {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            }else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
