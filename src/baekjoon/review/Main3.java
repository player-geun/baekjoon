package baekjoon.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3 {

    static int n, MAX, start;
    static boolean isCycle;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] check;

    public static void main(String[] args) throws IOException {
        input();
        search();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        MAX = 0;
        adjList = new ArrayList[n + 1];
        check = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }
    }

    public static void search() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                visited = new boolean[n + 1];
                adjList[i].add(j);
                adjList[j].add(i);
                start = i;
                int time = DFS(i, 1);
                adjList[i].remove(adjList[i].size() - 1);
                adjList[j].remove(adjList[j].size() - 1);
                if (MAX < time) {
                    MAX = time;
                }
            }
        }

        System.out.println(MAX);
    }

    public static int DFS(int node, int time) {
        visited[node] = true;
        for(int next : adjList[node]){
            if(!visited[next]){
                check[node] =  1;
                int temp = time + 1;
                return DFS(next, temp);
            }else if(node == start){
                isCycle = true;
                return time;
            }
        }

        return time;
    }
}
