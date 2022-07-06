package baekjoon.q10866;

import java.util.Scanner;

public class Main {

    public static int[] d = new int[10000];

    static int size = 0;

    static int front = 0;

    static int back = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {

            String str = in.next();

            switch (str) {

                case "push_front" : {
                    push_front(in.nextInt());
                    break;
                }

                case "push_back" : {
                    push_back(in.nextInt());
                    break;
                }

                case "pop_front" : {
                    sb.append(pop_front()).append('\n');
                    break;
                }

                case "pop_back" : {
                    sb.append(pop_back()).append('\n');
                    break;
                }

                case "size" : {
                    sb.append(size()).append('\n');
                    break;
                }

                case "empty" : {
                    sb.append(empty()).append('\n');
                    break;
                }

                case "front" : {
                    sb.append(front()).append('\n');
                    break;
                }

                case "back" : {
                    sb.append(back()).append('\n');
                    break;
                }
            }

        }
        System.out.println(sb);
    }

    public static void push_front(int x) {

        d[front] = x;

        front = (front - 1 + 10000) % 10000;
        size++;
    }

    public static void push_back(int x) {

        back = (back + 1) % 10000;
        size++;
        d[back] = x;
    }

    public static int pop_front() {

        if (size == 0) {
            return -1;
        }

        int result = d[(front + 1) % 10000];
        front = (front + 1) % 10000;
        size --;

        return result;
    }

    public static int pop_back() {

        if (size == 0) {
            return -1;
        }

        int result = d[back];
        back = (back - 1 + 10000) % 10000;
        size--;

        return result;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        }

        return 0;
    }

    public static int front() {

        if (size == 0) {
            return -1;
        }

        return d[(front + 1) % 10000];
    }

    public static int back() {

        if (size == 0) {
            return -1;
        }

        return d[back];
    }
}
