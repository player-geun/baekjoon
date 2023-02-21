package baekjoon.q1105;

import java.util.*;

public class Main {

    static String L, R;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.next();
        R = sc.next();

        if (L.length() != R.length()) {
            System.out.println(count);
            return;
        }

        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) == R.charAt(i)) {
                if (L.charAt(i) == '8') {
                    count++;
                }
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
