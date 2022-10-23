package baekjoon.q2799;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static int N, M;
    static int res[];
    static int count[];
    static int idx;
    static String str;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        res = new int [5];
        count = new int [N];
        for (int k = 0; k < M; k++) {
            sc.next();
            for (int i = 0; i < 4; i++) {
                str = sc.next();
                for (int j = 1; j < 5 * N  + 1; j += 5) {
                    if(str.charAt(j) == '*') {
                        count[idx]++;
                        idx++;
                    }
                }
                idx = 0;
            }
            for (int i = 0; i < N; i++) {
                res[count[i]]++;
            }
            Arrays.fill(count, 0);
        }
        sc.next();
        for (int i = 0; i < 5; i++) {
            System.out.print(res[i] + " ") ;
        }
    }
}
