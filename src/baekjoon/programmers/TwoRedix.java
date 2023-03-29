package baekjoon.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoRedix {

    public static void main(String[] args) {
        String s = "110010101001";

        int changeCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            char[] arr = s.toCharArray();
            int count = countZero(arr);
            zeroCount += count;
            s = Integer.toString(arr.length - count, 2);
            changeCount++;
        }

        System.out.println(changeCount + " " + zeroCount);
    }

    public static int countZero(char[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                count++;
            }
        }

        return count;
    }
}
