package baekjoon.q18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] queue = new int[2000000];

    static int size = 0;
    static int front = 0;
    static int back = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer command;

        for (int i = 0; i < n; i++) {

            command = new StringTokenizer(br.readLine(), " ");

            switch (command.nextToken()) {

                case "push":
                    push(Integer.parseInt(command.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int x) {
        queue[back] = x;
        back++;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            size --;

            return queue[front++];
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        }else {
            return 0;
        }
    }

    public static int front() {
        if (size == 0) {
            return -1;
        } else {
            return queue[front];
        }
    }

    public static int back() {
        if (size == 0) {
            return -1;
        } else {
            return queue[back - 1];
        }
    }
}
