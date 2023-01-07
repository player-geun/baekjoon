package baekjoon.q9663;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N, numberOfQueenCases;

    public static void main(String[] args) {
        input();
        DFS(0, new ArrayList<>());
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
    }

    public static void DFS(int currentRow, ArrayList<Integer> currentCandidate) {
        if (currentRow == N) {
            numberOfQueenCases++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isAvailable(currentCandidate, i)) {
                currentCandidate.add(i);
                DFS(currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public static boolean isAvailable(ArrayList<Integer> candidate, int currentColumn) {
        int currentRow = candidate.size();

        for (int i = 0; i < currentRow; i++) {
            if (candidate.get(i) == currentColumn || (Math.abs(candidate.get(i) - currentColumn)) == currentRow - i) {
                return false;
            }
        }

        return true;
    }

    public static void output() {
        System.out.println(numberOfQueenCases);
    }
}
