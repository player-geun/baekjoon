package baekjoon.q14620;

import java.util.*;

public class Main {

    static int N, minCost;
    static int[][] flowerBed;
    static boolean[][] isVisited;
    static ArrayList<int[]> possiblePoints;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        flowerBed = new int[N][N];
        isVisited = new boolean[N][N];
        possiblePoints = new ArrayList<>();
        minCost = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flowerBed[i][j] = sc.nextInt();
            }
        }

        // 3개의 점의 위치를 조합을 통해 고른다. 일차원 배열에서 고르고 해당 점의 위치를 2차원으로 변환한다.
        selectPoints(0);

        System.out.println(minCost);
    }

    public static void selectPoints(int start) {
        // 3 점을 고른다면
        if (possiblePoints.size() == 3) {
            // 꽃의 최소값 탐색
            calculateMinCost();
            // 방문 체크 초기화
            isVisited = new boolean[N][N];
            return;
       }

        for (int i = start; i < N * N; i++) {
            possiblePoints.add(changePoint(i));
            selectPoints(i + 1);
            possiblePoints.remove(possiblePoints.size() - 1);
        }
    }

    public static int[] changePoint(int point) {
        return new int[]{point / N, point % N};
    }

    public static void calculateMinCost() {
        int sumOfCost = 0;
        for (int[] now : possiblePoints) {
            isVisited[now[0]][now[1]] = true;
            sumOfCost += flowerBed[now[0]][now[1]];

            for (int i = 0; i < 4; i++) {
                int newY = now[0] + dy[i];
                int newX = now[1] + dx[i];

                // 꽃이 화단 밖으로 나가는 경우
                if (newY < 0 || newY >= N || newX < 0 || newX >= N) {
                    return;
                }

                // 꽃이 겹치는 경우
                if (isVisited[newY][newX]) {
                    return;
                }

                isVisited[newY][newX] = true;
                sumOfCost += flowerBed[newY][newX];
            }
        }

        minCost = Math.min(minCost, sumOfCost);
    }
}
