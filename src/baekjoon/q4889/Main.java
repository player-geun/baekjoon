package baekjoon.q4889;

import java.util.*;
import java.io.*;

public class Main {

    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        int index = 1;

        while((str = br.readLine()).charAt(0) != '-') {
            int minOperationCount = calculateMinOperationCount(str);

            if (!stack.isEmpty()) {
                minOperationCount += stack.size() / 2;
            }
            sb.append(index++).append(". ").append(minOperationCount).append("\n");
        }

        System.out.println(sb);
    }

    public static int calculateMinOperationCount(String str) {
        stack = new Stack<>();
        int minOperationCount = 0;
        char[] strArr = str.toCharArray();

        for(int i = 0; i < str.length(); i++) {
            if (strArr[i] == '{') {
                stack.push('{');
            } else {
                if(stack.isEmpty()) {
                    stack.push('{');
                    minOperationCount++;
                } else {
                    stack.pop();
                }
            }
        }

        return minOperationCount;
    }
}
