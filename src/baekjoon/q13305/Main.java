package baekjoon.q13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] cityMap;
    static int N, allFuelingCharge;

    public static void main(String[] args) {

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cityMap = new int[N][2];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            cityMap[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            cityMap[i][1] = Integer.parseInt(st.nextToken());
        }
    }

}
