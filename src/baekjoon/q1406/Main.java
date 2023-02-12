package baekjoon.q1406;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static String line;
    static int N;
    static Stack<Character> leftStack;
    static Stack<Character> rightStack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        line = sc.next();
        N = sc.nextInt();
        leftStack = new Stack<>();
        rightStack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            leftStack.push(line.charAt(i));
        }

        int cursor = leftStack.size();

        for (int i = 0; i < N; i++) {
            String command = sc.next();

            if (command.equals("L")) {
                if (leftStack.size() == 0) {
                    continue;
                }
                cursor--;
                rightStack.push(leftStack.pop());
            } else if (command.equals("D")) {
                if (rightStack.size() == 0) {
                    continue;
                }
                cursor++;
                leftStack.push(rightStack.pop());
            } else if (command.equals("B")) {
                if (leftStack.size() == 0) {
                    continue;
                }
                leftStack.pop();
                cursor--;
            } else {
                leftStack.push(sc.next().charAt(0));
                cursor++;
            }
        }

        for (char alphabet : leftStack) {
            sb.append(alphabet);
        }

        System.out.print(sb);
        sb.delete(0, sb.length());

        for (char alphabet : rightStack) {
            sb.append(alphabet);
        }

        sb.reverse();

        System.out.println(sb);
    }
}
