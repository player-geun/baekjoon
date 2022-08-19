package baekjoon.q1717;

import java.util.Scanner;

public class Main {

    static int[] parent;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];

        // 대표노드를 자기 저신으로 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 합집합 : union
            if (question == 0) {
                union(a, b);
            } else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {

        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean checkSame(int a, int b) {

        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}