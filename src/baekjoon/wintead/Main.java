package baekjoon.wintead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max;
    static int[] stones;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        findMax();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stones = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void findMax() {
        int startSum = 0;
        int sum1 = 0;
        int sum2 = 0;

        int initNum = init()- 1;

        for (int i = initNum + 1; i < N - 1; i++) {
            if (stones[initNum] == stones[i]) {
                sum1++;
            } else {
                sum2++;
            }
        }

        if (sum2 > sum1) {
            max = Math.max(sum2 - sum1, initNum + 1);
        } else {
            max = initNum + 1 + sum1 - sum2;
        }
    }

    public static int init() {
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            result = i;
            if (stones[i] != stones[i + 1]) {
                return i + 1;
            }
        }

        return result;
    }

    public static void output() {
        System.out.println(max);
    }
}
