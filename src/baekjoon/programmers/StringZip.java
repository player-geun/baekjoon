package baekjoon.programmers;

import java.util.ArrayList;
import java.util.List;

public class StringZip {

    public static void main(String[] args) {
        String s = "aaaaaaaaabaa";
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2 + 1; i++) {
            int zipLength = zip(s, i);

            if (zipLength < min) {
                min = zipLength;
            }
        }

        System.out.println(min);
    }

    public static int zip(String s, int zipCnt) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String lastToken = "";

        for (String token : cut(s, zipCnt)) {
            if (token.equals(lastToken)) {
                count++;
            } else {
                if(count > 1) sb.append(count);
                sb.append(lastToken);
                lastToken = token;
                count = 1;
            }
        }

        if(count > 1) sb.append(count);
        sb.append(lastToken);

        return sb.length();
    }

    public static List<String> cut(String s, int zipCnt) {
        List<String> tokens = new ArrayList<>();

        for (int i = 0; i < s.length(); i += zipCnt) {
            int end = i + zipCnt;
            if(end > s.length()) end = s.length();
            tokens.add(s.substring(i, end));
        }

        return tokens;
    }
}
