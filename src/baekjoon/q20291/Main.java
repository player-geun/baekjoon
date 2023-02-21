package baekjoon.q20291;

import java.util.*;

public class Main {

    static int N;
    static String[] files;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        files = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            String[] splitLine = line.split("[.]");
            files[i] = splitLine[splitLine.length - 1];
        }

        countSameFiles();

        System.out.println(sb);
    }

    public static void countSameFiles() {
        Arrays.sort(files, 1, N + 1);
        int count = 1;
        for (int i = 2; i <= N; i++) {
            if (files[i - 1].equals(files[i])) {
                count++;
            } else {
                sb.append(files[i - 1]).append(" ").append(count).append('\n');
                count = 1;
            }
            if (i == N) {
                sb.append(files[i]).append(" ").append(count).append('\n');
            }
        }
    }
}
