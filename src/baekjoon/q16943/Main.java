package baekjoon.q16943;

import java.util.*;

public class Main {

    static String A;
    static int B, maxPossibleNum;
    static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.nextInt();
        isUsed = new boolean[A.length()];

        compareAllNumbersOfCase(0, "");

        System.out.println(maxPossibleNum == 0 ? -1 : maxPossibleNum);
    }

    public static void compareAllNumbersOfCase(int digit, String num) {
        if (digit == A.length()) {
            if(num.charAt(0) == '0') return;

            if (Integer.valueOf(num) < B) {
                maxPossibleNum = Math.max(maxPossibleNum, Integer.valueOf(num));
            }

            return;
        }

        for (int i = 0; i < A.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                compareAllNumbersOfCase(digit + 1, num + A.charAt(i));
                isUsed[i] = false;
            }
        }
    }
}
