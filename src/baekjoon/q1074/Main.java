package baekjoon.q1074;

import java.util.*;

public class Main {

    static int N, r, c, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        find(0, (int) (Math.pow(4, N) - 1));

        System.out.println(result);
    }

    public static void find(int min, int max) {
        int line = (int) Math.sqrt(max - min + 1);
        if (line == 1) {
            result = min;
            return;
        }

        if (r < line / 2 + min) {
            if (c < line / 2 + min) {
                find(min, (max + 1) / 4 - 1);
            } else {
                find(min + line / 2 * line / 2, (max + 1) / 2 - 1);
            }
        } else {
            if (c < line / 2 + min) {
                find(min + line / 2 * line / 2 * 2, (max + 1) / 4 * 3 - 1);
            } else {
                find(min + line / 2 * line / 2 * 3, max);
            }
        }
    }
}
