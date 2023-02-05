package baekjoon.q1193;

import java.util.Scanner;

public class Main {

    static int X;
    static Node now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        now = new Node(1, 1);

        findFraction();

        System.out.println(now.x + "/" + now.y);
    }

    public static void findFraction() {
        int index = 1;
        int depth = 1;
        int remainingDistance = 0;
        boolean isUnder = false;
        while (index != X) {
            if (remainingDistance == 0 && !isUnder) {
                now = new Node(now.x, now.y + 1);
                remainingDistance = depth++;
                isUnder = true;
                index++;
            } else if (remainingDistance == 0 && isUnder) {
                now = new Node(now.x + 1, now.y);
                remainingDistance = depth++;
                isUnder = false;
                index++;
            } else {
                if (isUnder) {
                    now = new Node(now.x + 1, now.y - 1);
                } else {
                    now = new Node(now.x - 1, now.y + 1);
                }
                remainingDistance--;
                index++;
            }
        }
    }

    static class Node{

        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
