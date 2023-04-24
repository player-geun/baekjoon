package baekjoon.q1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] relations;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        relations = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            relations[f1].add(f2);
            relations[f2].add(f1);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            BFS(i, N);
        }

        System.out.println(result);
    }

    static void BFS(int start, int N) {
        Queue<int[]> que = new LinkedList<>();
        int count = 0;

        visit[start] = true;
        que.offer(new int[]{start, 0});

        while( !que.isEmpty() ) {
            int[] bacon = que.poll();
            count += bacon[1];

            for (int friend : relations[bacon[0]]) {
                if (!visit[friend]) {
                    visit[friend] = true;
                    que.offer(new int[]{friend, bacon[1] + 1});
                }
            }
        }

        if(min > count) {
            min = count;
            result = start;
        }

    }
}
