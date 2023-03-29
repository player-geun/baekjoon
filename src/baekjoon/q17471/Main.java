package baekjoon.q17471;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, min;
    static int[] numberOfPeople;
    static ArrayList<Integer>[] map;
    static ArrayList<Integer> firstSection;
    static ArrayList<Integer> secondSection;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numberOfPeople = new int[N + 1];
        map = new ArrayList[N + 1];
        firstSection = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            numberOfPeople[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int count = sc.nextInt();
            map[i] = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                map[i].add(sc.nextInt());
            }
        }

        selectNodes(1);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void selectNodes(int start) {
        if (firstSection.size() > N / 2) {
            return;
        }

        for (int i = start; i <= N; i++) {
            firstSection.add(i);
            divideTwoSection();
            calculateMin();
            selectNodes(i + 1);
            firstSection.remove((Integer) i);
        }
    }

    public static void divideTwoSection() {
        boolean[] isUsed = new boolean[N + 1];
        for (int node : firstSection) {
            isUsed[node] = true;
        }

        secondSection = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                secondSection.add(i);
            }
        }
    }

    public static void calculateMin() {
        isVisited = new boolean[N + 1];

        if (!isConnected(firstSection.get(0), firstSection)) {
            return;
        }

        if (!isConnected(secondSection.get(0), secondSection)) {
            return;
        }

        int firstSum = 0;
        for (int index : firstSection) {
            firstSum += numberOfPeople[index];
        }

        int secondSum = 0;
        for (int index : secondSection) {
            secondSum += numberOfPeople[index];
        }

        min = Math.min(min, Math.abs(firstSum - secondSum));
    }

    public static boolean isConnected(int start, ArrayList<Integer> section) {
        Queue<Integer> queue = new LinkedList<>();
        int connectedCount = 1;
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : map[now]) {
                if (!isVisited[next] && section.contains(next)) {
                    isVisited[next] = true;
                    queue.add(next);
                    connectedCount++;
                }
            }
        }

        if (connectedCount == section.size()) {
            return true;
        }

        return false;
    }
}
