package baekjoon.q1027;

import java.util.*;

public class Main {

    static int N, max;
    static int[] buildings;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        buildings = new int[N];

        for (int i = 0; i < N; i++) {
            buildings[i] = sc.nextInt();
        }

        selectBuilding();

        System.out.println(N == 1 ? 0 : max);
    }

    public static void selectBuilding() {
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                max = Math.max(max, calculateRightShowingBuildings(i));
            } else if (i == N - 1) {
                max = Math.max(max, calculateLeftShowingBuildings(i));
            } else {
                int sum = calculateRightShowingBuildings(i) + calculateLeftShowingBuildings(i);
                max = Math.max(max, sum);
            }
        }
    }

    public static int calculateLeftShowingBuildings(int now) {
        int next = now - 1;
        int count = 0;

        if (buildings[next] >= buildings[now]) {
            return 1;
        }

        while (buildings[next] < buildings[now]) {
            count++;
            if (next == 0) {
                break;
            }
            next--;
        }

        return count;
    }

    public static int calculateRightShowingBuildings(int now) {
        int next = now + 1;
        int count = 0;

        if (buildings[next] >= buildings[now]) {
            return 1;
        }

        while (buildings[next] < buildings[now]) {
            count++;

            if (next == N - 1) {
                break;
            }

            next++;
        }

        return count;
    }
}
