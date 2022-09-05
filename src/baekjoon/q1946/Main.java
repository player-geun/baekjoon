package baekjoon.q1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cnt = Integer.parseInt(br.readLine());
            Node[] A = new Node[cnt];

            for (int j = 0; j < cnt; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                A[j] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(A);

            int min = A[0].value2;
            int result = 0;

            for (Node a : A) {
                if (min >= a.value2) {
                    min = a.value2;
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    static class Node implements Comparable<Node>{
        int value1;
        int value2;

        Node(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public int compareTo(Node o) {
            return value1 - o.value1;
        }
    }
}
