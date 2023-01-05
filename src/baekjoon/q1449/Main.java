package baekjoon.q1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] pos;
    static int N, L, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pos = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        int now = pos[1];
        result = 1;

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 2; i < N + 1; i++) {
            if (now + L - 1 < pos[i]) {
                now = pos[i];
                result++;
            } else {
                while (now + L - 1 < pos[i]) {
                    i++;
                    if (i < N + 1) {
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
