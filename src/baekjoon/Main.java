package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

import java.util.*;

class Main {

    static ArrayList<ArrayList<Integer>> network;
    static boolean[] isVisited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        setNetwork(wires, n);

        for(int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            network.get(node1).remove((Integer) node2);
            network.get(node2).remove((Integer) node1);

            isVisited = new boolean[n + 1];
            dfs(node1);
            int sum1 = calculateNode(n);

            isVisited = new boolean[n + 1];
            dfs(node2);
            int sum2 = calculateNode(n);

            network.get(node1).add(node2);
            network.get(node2).add(node1);

            min = Math.min(min, Math.abs(sum1 - sum2));
        }

        System.out.println(min);
    }

    public static void setNetwork(int[][] wires, int n) {
        network = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }

        for(int i = 0; i < wires.length; i++) {
            network.get(wires[i][0]).add(wires[i][1]);
            network.get(wires[i][1]).add(wires[i][0]);
        }
    }

    public static void dfs(int node) {
        isVisited[node] = true;

        for(int i = 0; i < network.get(node).size(); i++) {
            if(!isVisited[network.get(node).get(i)]) {
                dfs(network.get(node).get(i));
            }
        }
    }

    public static int calculateNode(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(isVisited[i]) {
                count++;
            }
        }
        return count;
    }
}
