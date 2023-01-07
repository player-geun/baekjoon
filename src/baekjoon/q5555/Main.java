package baekjoon.q5555;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String findingString;
    static int N, containedRingCount;
    static String[] givenStrings;

    public static void main(String[] args) throws IOException {
        input();
        countSubString();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        findingString = br.readLine();
        N = Integer.parseInt(br.readLine());
        givenStrings = new String[N];

        for (int i = 0; i < N; i++) {
            givenStrings[i] = br.readLine();
        }
    }

    public static void countSubString() {
        String newString;
        for (int i = 0; i < N; i++) {
            newString = givenStrings[i] + givenStrings[i];
            if (newString.contains(findingString)) {
                containedRingCount++;
            }
        }
    }

    public static void output() {
        System.out.println(containedRingCount);
    }
}
