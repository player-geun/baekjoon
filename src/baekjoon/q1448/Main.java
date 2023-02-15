package baekjoon.q1448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static Integer[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new Integer[N];

        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines, Collections.reverseOrder());

        int max = 0;

        for (int i = 0; i < lines.length - 2; i++) {
            if (lines[i] < lines[i + 1] + lines[i + 2]) {
                max = Math.max(max , lines[i] + lines[i + 1] + lines[i + 2]);
            }
        }

        if (max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }
}
