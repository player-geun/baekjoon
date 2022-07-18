package baekjoon.q13023;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[]3334441 visited;`¡™£££££¢
    static boolean arrive;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        A = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static void DFS(int v ,int depth) {

        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }

        visited[v] = false;
    }
}
