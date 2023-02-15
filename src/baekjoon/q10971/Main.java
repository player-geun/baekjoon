package baekjoon.q10971;

import java.util.*;

public class Main {

    static int N, min, startPoint;
    static boolean[] isVisited;
    static int[][] costs;

    public static void main(String[] args) {
        // 입력 받기, 1 ~ N번 까지의 도시
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        isVisited = new boolean[N + 1];
        costs = new int[N + 1][N + 1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        // 재귀 탐색, 가지치기(이미 방문했는지 체크)
        for (int start = 1; start <= N; start++) {
            isVisited[start] = true;
            startPoint = start;
            findCircleRoad(start, 1, 0);
            isVisited[start] = false;
        }

        System.out.println(min);
    }

    public static void findCircleRoad(int start, int visitedCityCount, int sumOfCosts) {
        if (visitedCityCount == N && costs[start][startPoint] != 0) {
            min = Math.min(min, sumOfCosts + costs[start][startPoint]);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i] && costs[start][i] != 0) {
                isVisited[i] = true;
                int newSumOfCosts = sumOfCosts + costs[start][i];
                findCircleRoad(i, visitedCityCount + 1, newSumOfCosts);
                isVisited[i] = false;
            }
        }
    }
}

