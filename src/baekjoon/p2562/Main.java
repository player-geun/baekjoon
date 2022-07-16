package baekjoon.p2562;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node[] A = new Node[10];

        Node max = new Node(0, 0);

        for (int i = 1; i < 10; i++) {
            A[i] = new Node(sc.nextInt(), i);

            if (A[i].item > max.item) {
                max.item = A[i].item;
                max.seq = A[i].seq;
            }
        }

        System.out.println(max.item);
        System.out.println(max.seq);
    }

    private static class Node {

        int item;
        int seq;

        Node(int item, int seq) {
            this.item = item;
            this.seq = seq;
        }
    }
}
