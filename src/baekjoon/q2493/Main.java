package baekjoon.q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int[] tops, result;
    private static Stack<Top> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tops = new int[N];
        result = new int[N];
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        makeResult(N);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void makeResult(int N) {
        result[0] = 0;
        stack.push(new Top(tops[0], 1));

        for (int i = 1; i < N; i++) {
            if (stack.peek().height > tops[i]) {
                result[i] = stack.peek().index;
                stack.push(new Top(tops[i], i + 1));
                continue;
            }

            while (true) {
                if (stack.isEmpty()) {
                    result[i] = 0;
                    stack.push(new Top(tops[i], i + 1));
                    break;
                }

                if (stack.peek().height > tops[i]) {
                    result[i] = stack.peek().index;
                    stack.push(new Top(tops[i], i + 1));
                    break;
                }

                stack.pop();
            }
        }
    }

    public static class Top {

        private int height;
        private int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
