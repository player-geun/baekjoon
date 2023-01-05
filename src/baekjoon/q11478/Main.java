package baekjoon.q11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static String line;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        input();
        findSubString();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
    }

    public static void findSubString() {
        set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            String temp = "";

            for (int j = i; j < line.length(); j++) {
                temp += line.substring(j, j + 1);
                set.add(temp);
            }
        }
    }

    public static void output() {
        System.out.println(set.size());
    }
}
