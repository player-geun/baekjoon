package baekjoon.q9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String line, bomb;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        input();
        explore();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        bomb = br.readLine();
    }

    public static void explore() {
        stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean flag = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }
    }

    public static void output() {
        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) {
            sb.append("FRULA");
        }else {
            for (Character c : stack) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
