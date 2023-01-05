package baekjoon.q10974;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static ArrayList<Integer> numList;
    static boolean[] used;

    public static void main(String[] args) {
        input();
        rec(N, 0);
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numList = new ArrayList<>();
        used = new boolean[N + 1];
    }

    public static void rec(int depth, int num) {
        if (depth == 0) {
            numList.add(num);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (!used[i]) {
                used[i] = true;
                int newNum = num * 10 + i;
                rec(depth -1, newNum);
                used[i] = false;
            }
        }
    }

    public static void output() {
        Collections.sort(numList);

        for (int num : numList) {
            String stringNum = String.valueOf(num);
            for (int i = 0; i < stringNum.length(); i++) {
                System.out.print(stringNum.charAt(i) + " ");
            }
            System.out.println();
        }
    }
}
