package baekjoon.q1138;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] tallerPeopleCounts;
    static ArrayList<Integer> line;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tallerPeopleCounts = new int[N+1];
        line = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            tallerPeopleCounts[i] = sc.nextInt();
        }

        for (int i = N; i >= 1; i--) {
            line.add(tallerPeopleCounts[i], i);
        }

        for(int k : line) {
            System.out.print(k+" ");
        }
    }

}
