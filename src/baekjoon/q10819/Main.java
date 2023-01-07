package baekjoon.q10819;

import java.util.Scanner;

public class Main {

    static int N, maxNum;
    static int[] nums;
    static int[] newNums;
    static boolean[] isUsed;

    public static void main(String[] args) {
        input();
        DFS(0);
        output();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        newNums = new int[N];
        isUsed = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    public static void DFS(int depth) {
        if (depth == N) {
            int sum = calculate();
            if (maxNum < sum) {
                maxNum = sum;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                newNums[depth] = nums[i];
                DFS(depth + 1);
                isUsed[i] = false;
            }
        }
    }

    public static int calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(newNums[i] - newNums[i + 1]);
        }

        return sum;
    }

    public static void output() {
        System.out.println(maxNum);
    }
}
