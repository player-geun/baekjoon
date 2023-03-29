package baekjoon.q1254;

import java.util.*;

public class Main {

    private static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        str = sc.next();
        int originLength = str.length();
        int index = 0;

        while(true) {
            sb.setLength(0);
            String reversedStr = sb.append(str).reverse().toString();

            if(str.equals(reversedStr)) {
                break;
            }

            str = str.substring(0, originLength) + str.charAt(index++) + str.substring(originLength);
        }

        System.out.println(str.length());
    }
}
