package baekjoon.q9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String[] result = new String[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Arrays.fill(result, "");

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(BFS(A, B));
        }
    }

    public static String BFS(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int D = calculateD(now);
            int S = calculateS(now);
            int L = calculateL(now);
            int R = calculateR(now);

            if (D == B) {
                return result[0] + "D";
            } else {
                result[0] = result[0] + "D";
                queue.add(D);
            }

            if (S == B) {
                return result[1] + "S";
            } else {
                result[1] = result[1] + "S";
                queue.add(S);
            }
            if (L == B) {
                return result[2] + "L";
            } else {
                result[2] = result[2] + "L";
                queue.add(L);
            }
            if (R == B) {
                return result[3] + "R";
            } else {
                result[3] = result[3] + "R";
                queue.add(R);
            }
        }

        return null;
    }

    public static int calculateD(int A) {
        int newA = A * 2;
        if (newA > 9999) {
            newA %= 10000;
        }
        return newA;
    }

    public static int calculateS(int A) {
        int newA = A - 1;
        if (A == 0) {
            newA = 9999;
        }
        return newA;
    }

    public static int calculateL(int A) {
        String textA = String.valueOf(A);
        int length = textA.length();
        char[] arr = new char[length];

        for (int i = 0; i < length - 1; i++) {
            arr[i] = textA.charAt(i + 1);
        }
        arr[length - 1] = textA.charAt(0);

        return Integer.parseInt(String.valueOf(arr));
    }

    public static int calculateR(int A) {
        String textA = String.valueOf(A);
        int length = textA.length();
        char[] arr = new char[length];

        for (int i = 0; i < length - 1; i++) {
            arr[i + 1] = textA.charAt(length - 1);
        }
        arr[0] = textA.charAt(0);

        return Integer.parseInt(String.valueOf(arr));
    }

    public static class Node {

        private int number;
        private List<String> operators;

        public Node(int number, List<String> operators) {
            this.number = number;
            this.operators = operators;
        }
    }
}
