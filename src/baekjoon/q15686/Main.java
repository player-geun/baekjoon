package baekjoon.q15686;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, min;
    static int[][] cityMap;
    static ArrayList<int[]> personHouses;
    static ArrayList<int[]> chickenHouses;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        DFS(0, 0);
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cityMap = new int[N][N];
        personHouses = new ArrayList<>();
        chickenHouses = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cityMap[i][j] = Integer.parseInt(st.nextToken());

                if (cityMap[i][j] == 1) {
                    personHouses.add(new int[]{i, j});
                } else if (cityMap[i][j] == 2) {
                    chickenHouses.add(new int[]{i, j});
                }
            }
        }

        isVisited = new boolean[chickenHouses.size()];
    }

    public static void DFS(int visitedCount, int start) {
        int sumMinDistance = 0;
        if (visitedCount == M) {
            for (int i = 0; i < personHouses.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chickenHouses.size(); j++) {
                    if (isVisited[j]) {
                        int distance = Math.abs(personHouses.get(i)[0] - chickenHouses.get(j)[0])
                                + Math.abs(personHouses.get(i)[1] - chickenHouses.get(j)[1]);

                        minDistance = Math.min(minDistance, distance);
                    }
                }

                sumMinDistance += minDistance;
            }
            min = Math.min(sumMinDistance, min);
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            isVisited[i] = true;
            DFS(visitedCount + 1, i + 1);
            isVisited[i] = false;
        }
    }

    public static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(min + "\n");
        bw.flush();
    }
}
