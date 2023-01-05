package baekjoon.q1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int E, S, M, date;
    static int[][][] ESMCalendar = new int[16][29][20];

    public static void main(String[] args) throws IOException {
        input();
        setESMCalendar();
        findDate();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public static void setESMCalendar() {
        int e = 1;
        int s = 1;
        int m = 1;
        int date = 1;

        while (e != 15 || s != 28 || m != 19) {
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }

            ESMCalendar[e++][s++][m++] = date++;
        }

        ESMCalendar[15][28][19] = 7980;
    }

    public static void findDate() {
        date = ESMCalendar[E][S][M];
    }

    public static void output() {
        System.out.println(date);
    }
}
