package baekjoon.q1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
     static List<Long> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        findReducingNum();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    public static void findReducingNum() {
        for(int i = 0; i < 10; i++) {
            DFS(i);
        }
    }

    private static void DFS(long num) {
        numList.add(num);
        long modValue = num % 10;
        if(modValue == 0) {
            return;
        }

        for(long i=modValue-1; i>=0; i--) {
            long newValue = num * 10 + i;
            DFS(newValue);
        }

        Collections.sort(numList);
    }

    public static void output() {
        if (N >= 1023) {
            System.out.print(-1);
        } else {
            System.out.print(numList.get(N));
        }
    }
}
