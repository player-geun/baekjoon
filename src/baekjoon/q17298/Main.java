package baekjoon.q17298;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static private class Pair {

        int num;
        int seq;

        Pair(int num, int seq) {

            this.num = num;
            this.seq = seq;
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Pair> stack = new Stack<>();

        int n = in.nextInt();
        Pair[] pair = new Pair[n];
        int[] arr = new int[n];

        Arrays.fill(arr, -1);

        for (int i = 0; i < n; i++) {

            Pair p = new Pair(in.nextInt(), i);
            pair[i] = p;
        }

        for (Pair p : pair) {

            while (!stack.empty() && stack.peek().num < p.num) {

                arr[stack.peek().seq] = p.num;
                stack.pop();
            }

            stack.push(p);
        }

        for (int item : arr) {
            sb.append(item).append(" ");
        }

        System.out.println(sb);
    }
}
