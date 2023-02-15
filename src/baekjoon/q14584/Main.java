package baekjoon.q14584;

import java.util.*;

public class Main {

    static String encoding;
    static int N;
    static String[] dictionary;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        encoding = sc.next();
        N = sc.nextInt();
        dictionary = new String[N];

        for (int i = 0; i < N; i++) {
            dictionary[i] = sc.next();
        }

        Queue<Character> queue = new LinkedList<>();

        char[] encodingToChar = encoding.toCharArray();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < encoding.length(); j++) {
                encodingToChar[j] = (char)('a'+((encodingToChar[j]-'a'+1)%26));
            }

            String line = String.valueOf(encodingToChar);

            for (int k = 0; k < N; k++) {
                if (line.contains(dictionary[k])) {
                    System.out.println(line);
                    return;
                }
            }
        }
    }
}
