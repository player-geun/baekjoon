package baekjoon.q1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String line;
    static int count;

    public static void main(String[] args) throws IOException {
        input();
        search();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        count = 0;
    }

    public static void search() {
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(index) != line.charAt(i)) {
                index = i;
                count ++;
            }
        }
    }

    public static void output() {
        System.out.println((int) Math.ceil((double) count/2));
    }
}
