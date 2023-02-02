package baekjoon.q17245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min, max, mid;
    static int[][] serverRoom;
    static long allComputers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        serverRoom = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                serverRoom[i][j] = Integer.parseInt(st.nextToken());
                allComputers += serverRoom[i][j];
                if (serverRoom[i][j] > max) {
                    max = serverRoom[i][j];
                }
            }
        }

        findMinMinute();

        System.out.println(max);
    }

    public static void findMinMinute() {
        while (min + 1 < max) {
            mid = (min + max) / 2;
            long possibleComputers = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (serverRoom[i][j] > mid) {
                        possibleComputers += mid;
                    } else {
                        possibleComputers += serverRoom[i][j];
                    }
                }
            }

            if (((double) possibleComputers / allComputers) >= 0.5) {
                max = mid;
            } else {
                min = mid;
            }
        }
    }
}
