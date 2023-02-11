package baekjoon.q12904;

import java.util.Scanner;

public class Main {

    static String S, T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();

        for (int i = T.length() - 1; i >= S.length(); i--) {
            if (T.charAt(i) == 'A') {
                T = T.substring(0, i);
            } else {
                String temp = T.substring(0, i);
                StringBuffer sb = new StringBuffer(temp);
                T = sb.reverse().toString();
            }
        }

        if (T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
