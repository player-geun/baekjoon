package baekjoon.q14426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> frontStringSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        frontStringSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= str.length(); j++) {
                frontStringSet.add(str.substring(0, j));
            }
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (frontStringSet.contains(str)) {
                count++;
            }
        }

        System.out.println(count);
    }
}