package baekjoon.q2504;

import java.util.*;

public class Main {

    static String inputString;
    static Stack<Character> stack;
    static boolean isNotRightString;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputString = sc.next();
        stack = new Stack<>();

        stack.push(inputString.charAt(0));
        int temp = 1;
        for (int i = 1; i < inputString.length(); i++) {
            char currentCharacter = inputString.charAt(i);
            if (currentCharacter == '(') {
                stack.push(currentCharacter);
                temp *= 2;
            } else if (currentCharacter == '[') {
                stack.push(currentCharacter);
                temp *= 3;
            } else {
                if (currentCharacter == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        result += temp;
                        temp /= 2;
                    } else {
                        isNotRightString = true;
                        break;
                    }
                } else {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        result += temp;
                        temp /= 3;
                    } else {
                        isNotRightString = true;
                        break;
                    }
                }
            }
        }

        if (!stack.isEmpty() || isNotRightString) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
