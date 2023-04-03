package baekjoon.q21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] honeys;
    private static int sumOfAll, max, maxHoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        honeys = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            sumOfAll += honeys[i];

            if(i == 0) continue;
            if(i == N - 1) continue;
            maxHoney = Math.max(maxHoney, honeys[i]);
        }

        calculateToRight(N);
        calculateToLeft(N);

        max = Math.max(max, sumOfAll + maxHoney - honeys[N - 1] - honeys[0]);

        System.out.println(max);
    }

    private static void calculateToLeft(int N) {
        int sum = honeys[N - 1];
        for (int i = N - 2; i > 0; i--) {
            sum += honeys[i];
            max = Math.max(max, sumOfAll - sum + sumOfAll - honeys[N - 1] - honeys[i]);
        }
    }

    private static void calculateToRight(int N) {
        int sum = honeys[0];
        for (int i = 1; i < N - 1; i++) {
            sum += honeys[i];
            max = Math.max(max, sumOfAll - sum + sumOfAll - honeys[0] - honeys[i]);
        }
    }
}
