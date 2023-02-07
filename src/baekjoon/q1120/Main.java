package baekjoon.q1120;

import java.io.*;
import java.util.*;

public class Main {

    static String A, B;
    static int minDifference;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.next();
        minDifference = Integer.MAX_VALUE;

        calculateMinDifference();

        System.out.println(minDifference);
    }

    public static void calculateMinDifference() {
        for (int i = 0; i <= B.length() - A.length(); i++) {
            int difference = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) {
                    difference++;
                }
            }
            minDifference = Math.min(minDifference, difference);
        }
    }
}
