package baekjoon.q7568;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Node[] A = new Node[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Node(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i].kg < A[j].kg && A[i].m < A[j].m) {
                    A[i].rank++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(A[i].rank + " ");
        }
    }

    static class Node {
        int kg;
        int m;

        int rank;

        Node(int kg, int m) {
            this.kg = kg;
            this.m = m;
            this.rank = 1;
        }
    }
}
