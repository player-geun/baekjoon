package baekjoon.q2644;

import java.util.*;

public class Main {

    static int n, firstPerson, secondPerson, m, count;
    static ArrayList<Integer>[] connections;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        firstPerson = sc.nextInt();
        secondPerson = sc.nextInt();
        m = sc.nextInt();
        connections = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            connections[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            connections[parent].add(child);
            connections[child].add(parent);
        }

        countConnection(firstPerson, 0);

        if (count == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(count);
    }

    public static void countConnection(int person, int depth) {
        if (person == secondPerson) {
            count = depth;
            return;
        }

        for (int candidate : connections[person]) {
            if(!check[candidate]){
                check[candidate] = true;
                countConnection(candidate, depth + 1);
                check[candidate] = false;
            }
        }
    }
}
