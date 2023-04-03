package baekjoon.q18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] ground;
    private static int maxHeight, minHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        ground = new int[N][M];
        maxHeight = Integer.MIN_VALUE;
        minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, ground[i][j]);
                minHeight = Math.min(minHeight, ground[i][j]);
            }
        }

        int[] result = findMinTimeWithHeight(N, M, B);

        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] findMinTimeWithHeight(int N, int M, int B) {
        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int i = minHeight; i <= maxHeight; i++) {
            int time = 0;
            int inventory = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diffOfBlock = ground[j][k] - i;

                    if (diffOfBlock > 0) {
                        time += Math.abs(diffOfBlock) * 2;
                        inventory += Math.abs(diffOfBlock);
                    } else if (diffOfBlock < 0) {
                        time += Math.abs((diffOfBlock));
                        inventory -= Math.abs(diffOfBlock);
                    }
                }
            }

            if (inventory >= 0) {
                if (time <= minTime) {
                    minTime = time;
                    height = i;
                }
            }
        }

        return new int[]{minTime, height};
    }
}
