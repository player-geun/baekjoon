package baekjoon.q1068;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, count;
    static int[] parents;
    static int deletingNode, rootNode;
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parents = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            parents[i] = sc.nextInt();
        }
        deletingNode = sc.nextInt();

        // 트리 세팅하기
        initTree();

        if (deletingNode == rootNode) {
            System.out.println(0);
            return;
        }

        //노드 삭제하기
        deleteNode();

        //루트에서 탐색 시작하여 더이상 갈 수 없을 때
        countLeafNode();

        System.out.println(count);
    }

    public static void initTree() {
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            if (parents[i] == -1) {
                rootNode = i;
                continue;
            }
            tree[parents[i]].add(i);
        }
    }

    public static void deleteNode() {
        tree[parents[deletingNode]].remove((Integer) deletingNode);
    }

    public static void countLeafNode() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        isVisited[rootNode] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (tree[now].size() == 0) {
                count++;
            }

            for (int i = 0; i < tree[now].size(); i++) {
                int newNode = tree[now].get(i);

                if(isVisited[newNode]) continue;

                queue.add(newNode);
                isVisited[newNode] = true;
            }
        }
    }
}
