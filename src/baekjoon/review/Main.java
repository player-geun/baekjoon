

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, sum, MIN;
    static Node A;
    static Node B;
    static Node[] peoples;
    static Node[] temp;
    static boolean isA, isB;

    public static void main(String[] args) throws IOException {
        input();
        split();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        peoples = new Node[n];
        temp = new Node[n];
        sum = 0;
        MIN = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            peoples[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        A = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        B = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    public static void split() {
        for (Node people : peoples) {
            int a = Math.abs(people.x - A.x) + Math.abs(people.y - A.y);
            int b = Math.abs(people.x - B.x) + Math.abs(people.y - B.y);
            if (a < b) {
                isA = true;
                sum += a;
            } else {
                isB = true;
                sum += b;
            }
        }

        if (!isA || !isB) {
            int index = 0;
            for (Node people : peoples) {
                int a = Math.abs(people.x - A.x) + Math.abs(people.y - A.y);
                int b = Math.abs(people.x - B.x) + Math.abs(people.y - B.y);
                if (MIN > b) {
                    MIN = b;
                }
                temp[index++] = new Node(a, b);
            }

            for (Node p : temp) {
                if (p.y == MIN) {
                    sum -= p.x;
                    sum += p.y;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
