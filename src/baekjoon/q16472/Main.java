package baekjoon.q16472;

import java.util.*;

public class Main {

    static int N, max, count;
    static String inputLine;
    static int[] isUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        inputLine = sc.next();
        isUsed = new int[26];

        findMaxLineLength();

        System.out.println(max);
    }

    public static void findMaxLineLength() {
        for (int right = 0, left = 0; right < inputLine.length(); right++) {
            moveRight(right);

            while (count > N) {
                moveLeft(left++);
            }

            max = Math.max(max, right - left + 1);
        }
    }

    public static void moveRight(int right) {
        isUsed[inputLine.charAt(right) - 'a']++;
        if (isUsed[inputLine.charAt(right) - 'a'] == 1) {
            count++;
        }
    }

    public static void moveLeft(int left) {
        isUsed[inputLine.charAt(left) - 'a']--;
        if (isUsed[inputLine.charAt(left) - 'a'] == 0) {
            count--;
        }
    }
}
