package baekjoon.q14912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, d, count;

    public static void main(String[] args) throws IOException {
        input();
        countDigit();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

    }

    public static void countDigit() {
        for (int i = 1; i < n + 1; i++) {
            String line = String.valueOf(i);

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) - '0' == d) {
                    count++;
                }
            }
        }
    }

    public static void output() {
        System.out.println(count);
    }
}
