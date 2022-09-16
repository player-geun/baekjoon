package baekjoon.q2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] pos = new int[N][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            pos[i][0] = Integer.parseInt(line.split(" ")[0]);
            pos[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int x = pos[0][0];
        int y = pos[0][1];
        int len = y - x;

        for(int i = 1; i < N; i++) {
            if(x <= pos[i][0] && pos[i][1] <= y) {
                // 포함
                continue;
            } else if(pos[i][0] < y) {
                // 겹침
                len += pos[i][1] - y;
            } else {
                // 안 겹침
                len += pos[i][1] - pos[i][0];
            }

            x = pos[i][0];
            y = pos[i][1];
        }

        System.out.println(len);
    }
}
